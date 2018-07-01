package com.dzz.medical.controller.system.dao;


import com.dzz.medical.controller.system.domain.dto.department.DepartmentPermitDTO;
import com.dzz.medical.controller.system.domain.model.BsAdminUserPermit;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminUserPermitMapper extends Mapper<BsAdminUserPermit> {
    /**
     * 根据userId删除用户权限
     * @param userId userId
     * @return 结果
     */
    int deleteByUserId(@Param("userId") String userId);

    /**
     * 更新用户的权限状态数据
     * @param status 状态
     * @param id 用户菜单id
     * @param userCode 操作人code
     */
    void updateStatus(@Param("status") Integer status, @Param("id") String id,
            @Param("userCode") String userCode);

    /**
     * 根据用户id查询权限id
     * @param userId 用户id
     * @return 权限id集合
     */
    List<String> selectByUserId(@Param("userId") String userId);

    /**
     * 查询部门权限编辑后 ,部门员工拥有多余权限的用户id
     * @param departmentId 部门id
     * @param permitList 部门现有权限id
     * @return
     */
    List<String> selectRemovedPermitUserId(@Param("departmentId") String departmentId,
            @Param("permitList") List<DepartmentPermitDTO> permitList);
}