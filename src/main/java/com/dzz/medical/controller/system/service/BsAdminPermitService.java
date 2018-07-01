package com.dzz.medical.controller.system.service;


import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.dto.permit.BsAdminPermitDTO;
import com.dzz.medical.controller.system.domain.vo.BsMenuVO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 权限菜单接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午6:07
 */
public interface BsAdminPermitService {

    String BASE_URL = "/api/bs_permit";

    /**
     * 获取所有有效菜单，用于新增权限
     *
     * @return 菜单列表
     */
    @RequestMapping(value = BASE_URL + "/listMenu", method = RequestMethod.GET)
    List<BsMenuVO> listMenu();


    /**
     * 取用户所有菜单权限用于修改菜单权限
     *
     * @param userId       用户Id
     * @return 菜单列表
     */
    @RequestMapping(value = BASE_URL + "/listUserMenu", method = RequestMethod.GET)
    List<BsMenuVO> listMenu(@RequestParam("userId") String userId);

    /**
     * 取部门所有菜单权限用于修改菜单权限
     * @param userId userId
     * @param departmentId       部门Id
     * @return 菜单列表
     */
    @RequestMapping(value = BASE_URL + "/listUserMenuByDepartmentId", method = RequestMethod.GET)
    List<BsMenuVO> listMenuByDepartmentId(@RequestParam("userId") String userId,
            @RequestParam("departmentId") String departmentId);

    /**
     * 取用户菜单权限 用于生成菜单
     *
     * @param userId       用户Id
     * @return 菜单列表
     */
    @RequestMapping(value = BASE_URL + "/listUserMenuExtend", method = RequestMethod.GET)
    List<BsMenuVO> listUserMenu(@RequestParam("userId") String userId);


    /**
     * 根据ID取菜单信息
     *
     * @param permitId     菜单ID
     * @return 菜单信息
     */
    @RequestMapping(value = BASE_URL + "/getAdminPermitById", method = RequestMethod.GET)
    PermitBO getAdminPermitById(@RequestParam("permitId") String permitId);


    /**
     * 取所有菜单信息
     *
     * @return 菜单信息
     */
    @RequestMapping(value = BASE_URL + "/listAdminPermit", method = RequestMethod.GET)
    List<PermitBO> listAdminPermit();

    /**
     * 新增菜单信息
     *
     * @param adminPermit 菜单信息
     * @return 更新是否成功
     */
    @RequestMapping(value = BASE_URL + "/addAdminPermit", method = RequestMethod.POST)
    Boolean addAdminPermit(@RequestBody BsAdminPermitDTO adminPermit);


    /**
     * 更新菜单信息
     *
     * @param adminPermit 菜单信息
     * @return 更新是否成功
     */
    @RequestMapping(value = BASE_URL + "/updateAdminPermit", method = RequestMethod.POST)
    Boolean updateAdminPermit(@RequestBody BsAdminPermitDTO adminPermit);

    /**
     * 更新菜单信息
     *
     * @param permitId 菜单Id
     * @param status   状态
     * @return 更新是否成功
     */
    @RequestMapping(value = BASE_URL + "/updateAdminPermitStatus", method = RequestMethod.POST)
    Boolean updateAdminPermitStatus(@RequestParam("permitId") String permitId, @RequestParam("status") String status);

}