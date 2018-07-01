package com.dzz.medical.controller.system.dao;


import com.dzz.medical.controller.system.domain.bo.BsRoleBO;
import com.dzz.medical.controller.system.domain.bo.ListRoleBO;
import com.dzz.medical.controller.system.domain.dto.role.ListRoleQueryDTO;
import com.dzz.medical.controller.system.domain.model.BsAdminRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminRoleMapper extends Mapper<BsAdminRole> {
    /**
     * 根据条件查询角色
     * @param listRoleQueryDTO 查询条件
     * @return 角色列表
     */
    List<ListRoleBO> selectByParam(ListRoleQueryDTO listRoleQueryDTO);

    /**
     * 根据部门id查询角色
     * @param departmentId 部门id
     * @return 角色列表
     */
    List<BsRoleBO> selectByDepartmentId(@Param("departmentId") String departmentId);

    /**
     * 根据部门id查询角色
     * @param departmentId 部门id
     * @param roleType roleType
     * @return 角色信息
     */
    BsRoleBO getByParam(@Param("departmentId") String departmentId, @Param("roleType") Integer roleType);
}