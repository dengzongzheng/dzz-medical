package com.dzz.medical.controller.system.service.impl;


import com.dzz.medical.controller.system.common.tools.BsMenuBuildTools;
import com.dzz.medical.controller.system.common.enums.PlatformEnum;
import com.dzz.medical.controller.system.dao.BsAdminPermitMapper;
import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.dto.permit.BsAdminPermitDTO;
import com.dzz.medical.controller.system.domain.model.BsAdminPermit;
import com.dzz.medical.controller.system.domain.vo.BsMenuVO;
import com.dzz.medical.controller.system.service.BsAdminPermitService;
import com.dzz.medical.controller.util.service.IdService;
import com.google.common.collect.Maps;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单权限接口相关实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:46
 */
@Service
@Slf4j
public class BsAdminPermitServiceImpl implements BsAdminPermitService {

    @Autowired
    private BsAdminPermitMapper bsAdminPermitMapper;

    @Autowired
    private IdService idService;


    @Override
    public List<BsMenuVO> listMenu() {
        List<PermitBO> adminPermit = bsAdminPermitMapper.listAdminPermit();
        Map<String, String> map = Maps.newHashMap();
        return BsMenuBuildTools.buildMenuTree(adminPermit, map);
    }

    @Override
    public List<BsMenuVO> listMenu(String userId) {
        /*用户菜单权限*/
        List<PermitBO> adminPermitList = bsAdminPermitMapper.listAdminPermitList(userId);

        /*所有菜单权限*/
        //List<PermitBO> allAdminPermitList = bsAdminPermitMapper.listAdminPermit();
        List<PermitBO> allAdminPermitList = bsAdminPermitMapper.listAdminPermitListByUserDepartment(userId);
        /*将用户菜单转成Map集合*/
        Map<String, String> userAdminPermitMap =
                adminPermitList.stream().collect(
                        Collectors.toMap(PermitBO::getPermitId, PermitBO::getPermitId));

        return BsMenuBuildTools.buildMenuTree(allAdminPermitList, userAdminPermitMap);
    }

    @Override
    public List<BsMenuVO> listMenuByDepartmentId(String userId, String departmentId) {
        /*部门菜单权限*/
        List<PermitBO> adminPermitList = bsAdminPermitMapper.listAdminPermitListByDepartmentId(departmentId);

        /*所有菜单权限*/
        List<PermitBO> allAdminPermitList = bsAdminPermitMapper.listAdminPermitList(userId);
        allAdminPermitList.addAll(adminPermitList);
        allAdminPermitList = allAdminPermitList.stream().distinct().collect(Collectors.toList());

        /*将用户菜单转成Map集合*/
        Map<String, String> userAdminPermitMap =
                adminPermitList.stream().distinct().collect(
                        Collectors.toMap(PermitBO::getPermitId, PermitBO::getPermitId));

        return BsMenuBuildTools.buildMenuTree(allAdminPermitList, userAdminPermitMap);
    }

    @Override
    public List<BsMenuVO> listUserMenu(String userId) {
        /*用户菜单权限*/
        List<PermitBO> adminPermitList = bsAdminPermitMapper.listAdminPermitList(userId);

        Map<String, String> map = Maps.newHashMap();
        return BsMenuBuildTools.buildMenuTree(adminPermitList, map);
    }

    @Override
    public PermitBO getAdminPermitById(String permitId) {
        return bsAdminPermitMapper.getAdminPermitById(permitId);
    }

    @Override
    public List<PermitBO> listAdminPermit() {
        return bsAdminPermitMapper.listAdminPermit();
    }

    @Override
    public Boolean addAdminPermit(BsAdminPermitDTO adminPermit) {
        Long id = idService.getId();
        Date date = new Date();
        BsAdminPermit addAdminPermit = new BsAdminPermit();
        BeanUtils.copyProperties(adminPermit, addAdminPermit);
        addAdminPermit.setId(id);
        addAdminPermit.setPermitId(String.valueOf(id));
        addAdminPermit.setPlatformId(PlatformEnum.MANAGE_ADMIN.getCode());
        addAdminPermit.setCreateTime(date);
        addAdminPermit.setCreator(adminPermit.getUserCode());
        addAdminPermit.setUpdateTime(date);
        addAdminPermit.setUpdator(adminPermit.getUserCode());
        addAdminPermit.setStatus(1);
        return bsAdminPermitMapper.insert(addAdminPermit) > 0;
    }


    public Boolean updateAdminPermit(BsAdminPermitDTO adminPermit) {

        BsAdminPermit updateAdminPermit = bsAdminPermitMapper.getByPermitId(adminPermit.getPermitId());
        BeanUtils.copyProperties(adminPermit, updateAdminPermit);
        updateAdminPermit.setUpdateTime(new Date());
        updateAdminPermit.setUpdator(adminPermit.getUserCode());
        return bsAdminPermitMapper.updateByPrimaryKeySelective(updateAdminPermit) > 0;
    }

    @Override
    public Boolean updateAdminPermitStatus(String permitId, String status) {
        return bsAdminPermitMapper.updateAdminPermitStatus(permitId, status) > 0;
    }
}
