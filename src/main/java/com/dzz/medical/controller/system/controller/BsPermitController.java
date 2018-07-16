package com.dzz.medical.controller.system.controller;import com.alibaba.fastjson.JSON;import com.dzz.medical.common.response.ResponseDzz;import com.dzz.medical.controller.system.common.enums.SystemUrlConstants;import com.dzz.medical.controller.system.domain.dto.permit.BsAdminPermitDTO;import com.dzz.medical.controller.system.domain.dto.permit.PermitAddFacadeDTO;import com.dzz.medical.controller.system.domain.dto.permit.PermitStatusUpdateFacadeDTO;import com.dzz.medical.controller.system.domain.dto.permit.PermitUpdateFacadeDTO;import com.dzz.medical.controller.system.domain.vo.BsMenuVO;import com.dzz.medical.controller.system.service.BsAdminPermitService;import com.dzz.medical.controller.util.controller.BaseController;import java.util.List;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.validation.BindingResult;import org.springframework.validation.annotation.Validated;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.ResponseBody;/** * 菜单权限管理 * * @author dzz * @since 2017年06月20 上午9:40 * @version 1.0.0 */@Controller@Slf4jpublic class BsPermitController extends BaseController {    @Autowired    private BsAdminPermitService bsAdminPermitService;    /**     * 进入菜单管理页     * @param map map     * @return 菜单管理页     */    @RequestMapping(value = SystemUrlConstants.MENU_MANGE,method = RequestMethod.GET)    @PreAuthorize("hasAuthority('"+ SystemUrlConstants.MENU_MANGE+"')")    public String menuManage(ModelMap map) {        List<BsMenuVO> bsMenuVOList = bsAdminPermitService.listMenu();        map.put("menuTree", JSON.toJSONString(bsMenuVOList));        return "/system/menu/menu_manage";    }    /**     * 新增菜单     * @param permitAddFacadeDTO 菜单实体数据     * @return 菜单新增结果     */    @RequestMapping(value = SystemUrlConstants.MENU_ADD,method = RequestMethod.POST)    @ResponseBody    public ResponseEntity<?> addMenu(@Validated @RequestBody PermitAddFacadeDTO permitAddFacadeDTO, BindingResult result) {        if (result.hasErrors()) {            return ResponseEntity.ok(build("0",buildValidateJSONError(result)));        }        BsAdminPermitDTO bsAdminPermitDTO = permitAddFacadeDTO.convertToBsAdminPermit();        bsAdminPermitDTO.setUserCode(getUserId());        bsAdminPermitService.addAdminPermit(bsAdminPermitDTO);        return ResponseEntity.ok(build("1", JSON.toJSONString(bsAdminPermitService.listMenu())));    }    /**     * 更新菜单状态数据     *     * @param permitStatusUpdateDTO 菜单更新实体     * @return 菜单状态更新结果     */    @RequestMapping(value = SystemUrlConstants.MENU_UPDATE_STATUS, method = RequestMethod.POST)    @ResponseBody    public ResponseEntity<?> updateMenuStatus(@RequestBody PermitStatusUpdateFacadeDTO permitStatusUpdateDTO) {        try {            bsAdminPermitService                    .updateAdminPermitStatus(permitStatusUpdateDTO.getPermitId(), permitStatusUpdateDTO.getStatus());            return ResponseEntity.ok(ResponseDzz.ok(JSON.toJSONString(bsAdminPermitService.listMenu())));        } catch (Exception e) {            return ResponseEntity.ok(ResponseDzz.build("0", e.getCause().getMessage()));        }    }    /**     * 更新菜单数据     *     * @param permitUpdateDTO 菜单信息实体     * @return 菜单更新结果     */    @RequestMapping(value = SystemUrlConstants.MENU_UPDATE, method = RequestMethod.POST)    @ResponseBody    public ResponseEntity<?> updateMenu(@Validated @RequestBody PermitUpdateFacadeDTO permitUpdateDTO,            BindingResult result) {        if (result.hasErrors()) {            return ResponseEntity.ok(build("0", buildValidateJSONError(result)));        }        BsAdminPermitDTO bsAdminPermitDTO = permitUpdateDTO.convertToBsAdminPermitDTO();        bsAdminPermitDTO.setUserCode(getUserId());        bsAdminPermitService.updateAdminPermit(bsAdminPermitDTO);        return ResponseEntity                .ok(build("1", JSON.toJSONString(bsAdminPermitService.listMenu())));    }    /**     * 根据ID获取菜单信息     * @param permitId 菜单Id     * @return 菜单信息     */    @RequestMapping(value = SystemUrlConstants.MENU_GET_MENU_BY_ID,method = RequestMethod.GET)    @ResponseBody    public ResponseEntity<?> getMenuById(@RequestParam("id") String permitId) {        return ResponseEntity.ok(build("1",bsAdminPermitService.getAdminPermitById(permitId)));    }}