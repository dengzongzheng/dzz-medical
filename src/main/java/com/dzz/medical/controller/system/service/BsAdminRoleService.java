package com.dzz.medical.controller.system.service;


import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.system.domain.bo.BsRoleBO;
import com.dzz.medical.controller.system.domain.bo.ListRoleBO;
import com.dzz.medical.controller.system.domain.dto.role.ListRoleQueryDTO;
import com.dzz.medical.controller.system.domain.dto.role.RoleAddDTO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 角色信息接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午6:09
 */
public interface BsAdminRoleService {

    String BASE_URL = "/api/bs_role";

    /**
     * 角色列表查询
     * @param listRoleQueryDTO 查询条件
     * @return 角色信息
     */
    @RequestMapping(value = BASE_URL + "/listRole", method = RequestMethod.POST)
    ResponseDzz<PageUtil<ListRoleBO>> listRole(@RequestBody ListRoleQueryDTO listRoleQueryDTO);

    /**
     * 添加角色
     * @param roleAddDTO 添加角色DTO
     * @return 返回结果
     */
    @RequestMapping(value = BASE_URL+"/addRole",method = RequestMethod.POST)
    ResponseDzz<String> addRole(@RequestBody RoleAddDTO roleAddDTO);

    /**
     * 根据部门id查询角色
     * @param departmentId 部门id
     * @return 部门角色信息
     */
    @RequestMapping(value = BASE_URL+"/selectRoleByDepartmentId",method = RequestMethod.GET)
    ResponseDzz<List<BsRoleBO>> selectRoleByDepartmentId(@RequestParam("departmentId") String departmentId);
}
