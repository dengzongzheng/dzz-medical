package com.dzz.medical.controller.system.service.impl;


import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.system.dao.BsAdminRoleMapper;
import com.dzz.medical.controller.system.domain.bo.BsRoleBO;
import com.dzz.medical.controller.system.domain.bo.ListRoleBO;
import com.dzz.medical.controller.system.domain.dto.role.ListRoleQueryDTO;
import com.dzz.medical.controller.system.domain.dto.role.RoleAddDTO;
import com.dzz.medical.controller.system.service.BsAdminRoleService;
import com.dzz.medical.controller.util.service.IdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户角色接口相关实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:46
 */
@Service
@Slf4j
public class BsAdminRoleServiceImpl implements BsAdminRoleService {

    @Autowired
    private IdService idService;

    @Autowired
    private BsAdminRoleMapper bsAdminRoleMapper;

    /**
     * 角色列表查询
     *
     * @param listRoleQueryDTO 查询条件
     * @return 查询结果
     */
    @Override
    public ResponseDzz<PageUtil<ListRoleBO>> listRole(ListRoleQueryDTO listRoleQueryDTO) {
        PageHelper.startPage(listRoleQueryDTO.getPageNo(), listRoleQueryDTO.getPageSize(), true);
        List<ListRoleBO> list=  bsAdminRoleMapper.selectByParam(listRoleQueryDTO);
        PageInfo<ListRoleBO> pageInfo = new PageInfo<>(list);
        PageUtil<ListRoleBO> pageUtil = new PageUtil();
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponseDzz.ok(pageUtil);
    }

    /**
     * 添加角色
     *
     * @param roleAddDTO 添加角色DTO
     * @return 返回结果
     */
    @Override
    public ResponseDzz<String> addRole(RoleAddDTO roleAddDTO) {

        String roleId = idService.getFormatId("JS");
        bsAdminRoleMapper.insert(roleAddDTO.convertToBsAdminRole(idService.getId(), roleId));
        return ResponseDzz.ok(roleId);

    }

    /**
     * 根据部门id查询角色
     * @param departmentId 部门id
     * @return 部门角色信息
     */
    @Override
    public ResponseDzz<List<BsRoleBO>> selectRoleByDepartmentId(String departmentId) {
        List<BsRoleBO> list=bsAdminRoleMapper.selectByDepartmentId(departmentId);
        return ResponseDzz.ok(list);
    }
}
