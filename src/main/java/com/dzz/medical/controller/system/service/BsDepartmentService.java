package com.dzz.medical.controller.system.service;


import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.system.domain.bo.DepartmentBO;
import com.dzz.medical.controller.system.domain.bo.ListDepartmentBO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentAddDTO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentUpdateDTO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 部门相关接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:23
 */
public interface BsDepartmentService {

    String BASE_URL = "/api/department";


    /**
     * 部门查询接口
     *
     * @param content 查询条件
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return 查询结果
     */
    @RequestMapping(value = BASE_URL + "/pageListDepartment", method = RequestMethod.GET)
    ResponseDzz<PageUtil<ListDepartmentBO>> pageListDepartment(@RequestParam("content") String content,
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize);

    /**
     * 新增部门信息
     * @param departmentAddDTO 部门信息
     * @return 新增结果
     */
    @RequestMapping(value=BASE_URL +"/addDepartment",method = RequestMethod.POST)
    ResponseDzz<String> addDepartment(@RequestBody DepartmentAddDTO departmentAddDTO);

    /**
     * 更新部门信息
     * @param departmentUpdateDTO 部门信息
     * @return 更新结果
     */
    @RequestMapping(value=BASE_URL +"/updateDepartment",method = RequestMethod.POST)
    ResponseDzz<String> updateDepartment(@RequestBody DepartmentUpdateDTO departmentUpdateDTO);

    /**
     * 根据部门ID获取部门信息
     *
     * @param departmentId 部门ID
     * @return 部门信息
     */
    @RequestMapping(value=BASE_URL +"/getDepartmentByDepartmentId",method = RequestMethod.GET)
    ResponseDzz<DepartmentBO> getDepartmentByDepartmentId(@RequestParam("departmentId") String departmentId);

    /**
     * 查询当前有效的所有部门列表
     * @return 部门列表信息
     */
    @RequestMapping(value = BASE_URL+"/listDepartment",method = RequestMethod.GET)
    ResponseDzz<List<DepartmentBO>> listDepartment();
}