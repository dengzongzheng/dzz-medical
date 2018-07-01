package com.dzz.medical.controller.system.dao;


import com.dzz.medical.controller.system.domain.bo.DepartmentBO;
import com.dzz.medical.controller.system.domain.bo.ListDepartmentBO;
import com.dzz.medical.controller.system.domain.model.BsAdminDepartment;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminDepartmentMapper extends Mapper<BsAdminDepartment> {

    /**
     * 根据条件查询部门列表
     * @param content 查询条件
     * @return 部门数据
     */
    List<ListDepartmentBO> pageListDepartment(@Param("content") String content);

    /**
     * 根据部门id查询部门
     * @param departmentId 部门id
     * @return 部门信息
     */
    DepartmentBO selectByDepartmentId(@Param("departmentId") String departmentId);

    /**
     * 查询有效的部门列表
     * @return 部门列表
     */
    List<DepartmentBO> selectEffective();
}