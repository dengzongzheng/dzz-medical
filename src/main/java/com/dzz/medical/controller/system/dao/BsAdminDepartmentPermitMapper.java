package com.dzz.medical.controller.system.dao;

import com.dzz.medical.controller.system.domain.model.BsAdminDepartmentPermit;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminDepartmentPermitMapper extends Mapper<BsAdminDepartmentPermit> {

    /**
     * 根据部门id输出部门权限
     * @param departmentId
     * @return 结果
     */
    int deletByDepartmentId(@Param("departmentId") String departmentId);

    /**
     * 根据部门id查询部门权限
     * @param departmentId 部门id
     * @return 部门权限id集合
     */
    List<String> selectByDepartmentId(@Param("departmentId") String departmentId);
}