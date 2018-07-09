package com.dzz.medical.controller.system.controller;

import com.alibaba.fastjson.JSON;
import com.dzz.medical.common.PageUtil;
import com.dzz.medical.common.ResponseDzz;
import com.dzz.medical.controller.system.common.enums.SystemUrlConstants;
import com.dzz.medical.controller.system.domain.bo.DepartmentBO;
import com.dzz.medical.controller.system.domain.bo.ListDepartmentBO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentAddDTO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentAddFacadeDTO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentUpdateDTO;
import com.dzz.medical.controller.system.domain.dto.department.DepartmentUpdateFacadeDTO;
import com.dzz.medical.controller.system.domain.vo.BsMenuVO;
import com.dzz.medical.controller.system.service.BsAdminPermitService;
import com.dzz.medical.controller.system.service.BsDepartmentService;
import com.dzz.medical.controller.util.controller.BaseController;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 部门管理Controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:02
 */
@Controller
@Slf4j
public class BsDepartmentController extends BaseController {


    @Autowired
    private BsAdminPermitService bsAdminPermitService;

    @Autowired
    private BsDepartmentService bsDepartmentService;

    /**
     * 进入部门管理页
     * @param map map
     * @return 部门管理页
     */
    @RequestMapping(value = SystemUrlConstants.DEPARTMENT_MANAGE,method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('"+ SystemUrlConstants.DEPARTMENT_MANAGE+"')")
    public String departmentManage(ModelMap map) {


        return "/system/department/department_manage";
    }


    /**
     * 部门信息查询
     *
     * @param content 查询条件
     * @param pageSize 每页条数
     * @param pageNo 当前页
     * @return 渠道信息
     */
    @RequestMapping(value = SystemUrlConstants.DEPARTMENT_SEARCH, method = RequestMethod.GET)
    @ResponseBody
    public ResponseDzz<PageUtil<ListDepartmentBO>> departmentQuery(@RequestParam("content") String content,
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize) {

        return bsDepartmentService.pageListDepartment(content, pageNo, pageSize);
    }

    /**
     * 进入部门新增页
     * @param map map
     * @return 部门管理页
     */
    @RequestMapping(value = SystemUrlConstants.TO_DEPARTMENT_ADD,method = RequestMethod.GET)
    public String toDepartmentAdd(ModelMap map) {

        List<BsMenuVO> menuVOList = bsAdminPermitService.listUserMenu(getUserId());
        map.put("menuTree", JSON.toJSONString(menuVOList));
        return "/system/department/department_add";
    }


    /**
     * 新增部门
     *
     * @param departmentAddFacadeDTO 实体数据
     * @return 部门新增结果
     */
    @RequestMapping(value = SystemUrlConstants.DEPARTMENT_ADD, method = RequestMethod.POST)
    @ResponseBody
    public ResponseDzz<String> addDepartment(@Validated @RequestBody DepartmentAddFacadeDTO departmentAddFacadeDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseDzz.fail("数据非法",buildValidateJSONError(result));
        }
        DepartmentAddDTO departmentAddDTO = departmentAddFacadeDTO.convertToDepartmentAddDTO();
        departmentAddDTO.setUserCode(getUserId());
        return bsDepartmentService.addDepartment(departmentAddDTO);
    }



    /**
     * 进入部门修改页面
     * @param map map
     * @return 部门修改页
     */
    @RequestMapping(value = SystemUrlConstants.TO_DEPARTMENT_UPDATE,method = RequestMethod.GET)
    public String toDepartmentUpdate(ModelMap map,@RequestParam("departmentId") String departmentId) {

        map.put("departmentId", departmentId);
        List<BsMenuVO> menuVOList = bsAdminPermitService.listMenuByDepartmentId(getUserId(),departmentId);
        map.put("menuTree", JSON.toJSONString(menuVOList));
        ResponseDzz<DepartmentBO> departmentBO = bsDepartmentService.getDepartmentByDepartmentId(departmentId);
        map.put("department", departmentBO.getData());
        return "/system/department/department_edit";
    }


    /**
     * 修改部门
     *
     * @param departmentUpdateFacadeDTO 实体数据
     * @return 修改部门结果
     */
    @RequestMapping(value = SystemUrlConstants.DEPARTMENT_UPDATE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseDzz<String>  updateDepartment(@Validated @RequestBody DepartmentUpdateFacadeDTO departmentUpdateFacadeDTO,
            BindingResult result) {

        if (result.hasErrors()) {
            return ResponseDzz.fail("数据非法",buildValidateJSONError(result));
        }
        DepartmentUpdateDTO departmentUpdateDTO = departmentUpdateFacadeDTO.convertToDepartmentUpdateDTO();
        departmentUpdateDTO.setUserCode(getUserId());
        return bsDepartmentService.updateDepartment(departmentUpdateDTO);
    }

}
