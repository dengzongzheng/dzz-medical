package com.dzz.medical.controller.system.service.impl;


import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.system.dao.BsAdminDepartmentMapper;
import com.dzz.medical.controller.system.dao.BsAdminDepartmentPermitMapper;
import com.dzz.medical.controller.system.dao.BsAdminPermitMapper;
import com.dzz.medical.controller.system.dao.BsAdminUserPermitMapper;
import com.dzz.medical.controller.system.domain.bo.DepartmentBO;
import com.dzz.medical.controller.system.domain.bo.ListDepartmentBO;
import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentAddDTO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentPermitDTO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentUpdateDTO;
import com.dzz.medical.controller.system.domain.model.BsAdminDepartment;
import com.dzz.medical.controller.system.domain.model.BsAdminDepartmentPermit;
import com.dzz.medical.controller.system.service.BsDepartmentService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 部门接口相关实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:46
 */
@Service
@Slf4j
public class BsDepartmentServiceImpl implements BsDepartmentService {


    @Autowired
    private BsAdminDepartmentMapper bsAdminDepartmentMapper;

    @Autowired
    private BsAdminDepartmentPermitMapper bsAdminDepartmentPermitMapper;

    @Autowired
    private IdService idService;

    @Autowired
    private BsAdminPermitMapper bsAdminPermitMapper;

    @Autowired
    private BsAdminUserPermitMapper bsAdminUserPermitMapper;

    /**
     * 按查询条件查询部门信息
     *
     * @param content  查询条件
     * @param pageNo   当前页
     * @param pageSize 每页条数
     * @return 部门信息
     */
    @Override
    public ResponseDzz<PageUtil<ListDepartmentBO>> pageListDepartment(String content, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<ListDepartmentBO> list = bsAdminDepartmentMapper.pageListDepartment(content);
        PageInfo<ListDepartmentBO> pageInfo = new PageInfo<>(list);
        PageUtil<ListDepartmentBO> pageUtil = new PageUtil();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponseDzz.ok(pageUtil);
    }

    /**
     * 新增部门
     *
     * @param departmentAddDTO 部门信息
     * @return 返回部门id
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseDzz<String> addDepartment(DepartmentAddDTO departmentAddDTO) {
        // 部门信息
        String departmentId = idService.getFormatId("BM");
        bsAdminDepartmentMapper.insert(departmentAddDTO.convertToBsAdminDepartment(idService.getId(), departmentId));

        //部门权限信息
        List<DepartmentPermitDTO> list = departmentAddDTO.getDepartmentPermitDTOList();
        if (!list.isEmpty()) {
            Date date = new Date();
            list.forEach(x -> {
                BsAdminDepartmentPermit bsAdminDepartmentPermit = new BsAdminDepartmentPermit();
                BeanUtils.copyProperties(x, bsAdminDepartmentPermit);
                bsAdminDepartmentPermit.setId(idService.getId());
                bsAdminDepartmentPermit.setDepartmentId(departmentId);
                bsAdminDepartmentPermit.setCreateTime(date);
                bsAdminDepartmentPermit.setUpdateTime(date);
                bsAdminDepartmentPermit.setCreator(departmentAddDTO.getUserCode());
                bsAdminDepartmentPermit.setUpdator(departmentAddDTO.getUserCode());
                bsAdminDepartmentPermit.setStatus(1);
                bsAdminDepartmentPermitMapper.insert(bsAdminDepartmentPermit);
            });
        }

        return ResponseDzz.ok(departmentId);
    }

    /**
     * 更新部门信息
     *
     * @param departmentUpdateDTO 部门更新DTO
     * @return 更新结果
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseDzz<String> updateDepartment(DepartmentUpdateDTO departmentUpdateDTO) {
        DepartmentBO bo=bsAdminDepartmentMapper.selectByDepartmentId(departmentUpdateDTO.getDepartmentId());
        BsAdminDepartment updateObj = new BsAdminDepartment();
        updateObj.setId(bo.getId());
        BeanUtils.copyProperties(departmentUpdateDTO, updateObj);

        bsAdminDepartmentMapper.updateByPrimaryKeySelective(updateObj);
        bsAdminDepartmentPermitMapper.deletByDepartmentId(departmentUpdateDTO.getDepartmentId());
        //部门权限信息
        List<DepartmentPermitDTO> list = departmentUpdateDTO.getDepartmentPermitDTOList();
        if (!list.isEmpty()) {
            Date date = new Date();
            list.forEach(x -> {
                BsAdminDepartmentPermit bsAdminDepartmentPermit = new BsAdminDepartmentPermit();
                BeanUtils.copyProperties(x, bsAdminDepartmentPermit);
                bsAdminDepartmentPermit.setId(idService.getId());
                bsAdminDepartmentPermit.setDepartmentId(departmentUpdateDTO.getDepartmentId());
                bsAdminDepartmentPermit.setCreateTime(date);
                bsAdminDepartmentPermit.setUpdateTime(date);
                bsAdminDepartmentPermit.setCreator(departmentUpdateDTO.getUserCode());
                bsAdminDepartmentPermit.setUpdator(departmentUpdateDTO.getUserCode());
                bsAdminDepartmentPermit.setStatus(1);
                bsAdminDepartmentPermitMapper.insert(bsAdminDepartmentPermit);
            });
        }
        // 将所有不再属于本部门权限的 部门员工权限配置数据改为无效
        List<String> permitIds=bsAdminUserPermitMapper.selectRemovedPermitUserId(departmentUpdateDTO.getDepartmentId(),
                departmentUpdateDTO.getDepartmentPermitDTOList());
        permitIds.forEach(x->{
            bsAdminUserPermitMapper.updateStatus(0,x,departmentUpdateDTO.getUserCode());
        });

        return ResponseDzz.ok(departmentUpdateDTO.getParentDepartmentId());
    }

    /**
     * 根据部门id查询部门信息
     *
     * @param departmentId 部门ID
     * @return 部门信息
     */
    @Override
    public ResponseDzz<DepartmentBO> getDepartmentByDepartmentId(String departmentId) {
        DepartmentBO departmentBO = bsAdminDepartmentMapper.selectByDepartmentId(departmentId);
        List<String> permitIds=bsAdminDepartmentPermitMapper.selectByDepartmentId(departmentId);
        if(!CollectionUtils.isEmpty(permitIds)) {
            List<PermitBO> permitBOS = bsAdminPermitMapper.selectByPermitId(permitIds);
            departmentBO.setPermitBOList(permitBOS);
        }
        return ResponseDzz.ok(departmentBO);
    }

    /**
     * 查询当前有效的所有部门列表
     *
     * @return 部门列表信息
     */
    @Override
    public ResponseDzz<List<DepartmentBO>> listDepartment() {
        return ResponseDzz.ok(bsAdminDepartmentMapper.selectEffective());
    }
}
