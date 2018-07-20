package com.dzz.medical.controller.system.service;


import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.system.domain.bo.AdminUserDetailBO;
import com.dzz.medical.controller.system.domain.bo.BsAdminUserBO;
import com.dzz.medical.controller.system.domain.bo.BsAdminUserBelongBO;
import com.dzz.medical.controller.system.domain.bo.ConfigurableUserBO;
import com.dzz.medical.controller.system.domain.bo.ListUserBO;
import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.dto.user.BsUserAddDTO;
import com.dzz.medical.controller.system.domain.dto.user.BsUserUpdateDTO;
import com.dzz.medical.controller.system.domain.dto.user.ListUserQueryDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserAuthorizationDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserBelongAddDTO;
import com.dzz.medical.controller.system.domain.dto.user.UserCancellationDTO;
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
public interface BsAdminUserService {

    String BASE_URL = "/api/bs_user";

    /**
     * 用户列表查询
     *
     * @param listUserQueryDTO 查询条件
     * @return 用户信息
     */
    @RequestMapping(value = BASE_URL + "/pageListUser", method = RequestMethod.POST)
    ResponseDzz<PageUtil<ListUserBO>> pageListUser(@RequestBody ListUserQueryDTO listUserQueryDTO);

    /**
     * 当前用户所在部门查询用户列表
     * @param listUserQueryDTO 查询条件
     * @param departmentId
     * @return
     */
    @RequestMapping(value = BASE_URL + "/pageListUserByDepartment", method = RequestMethod.POST)
    ResponseDzz pageListUserByDepartment(@RequestBody ListUserQueryDTO listUserQueryDTO,
            @RequestParam("departmentId") String departmentId);

    /**
     * 新增用户
     *
     * @param userAddDTO 用户新增实体
     * @return 用户id
     */
    @RequestMapping(value = BASE_URL + "/addUser", method = RequestMethod.POST)
    ResponseDzz<String> addUser(@RequestBody BsUserAddDTO userAddDTO);


    /**
     * 查询超级管理员权限信息
     * @return 权限信息
     */
    ResponseDzz<List<PermitBO>> selectSupperAdminAuthorize();

    /**
     * 根据用户id查询权限信息
     *
     * @param userId 用户id
     * @return 权限信息
     */
    @RequestMapping(value = BASE_URL + "/selectAuthorizeByUserId", method = RequestMethod.GET)
    ResponseDzz<List<PermitBO>> selectAuthorizeByUserId(@RequestParam("userId") String userId);

    /**
     * 为用户授权
     *
     * @param userAuthorizationDTO 用户授权DTO
     * @return 返回结果
     */
    @RequestMapping(value = BASE_URL + "/authorizeUser", method = RequestMethod.POST)
    ResponseDzz<String> authorizeUser(@RequestBody UserAuthorizationDTO userAuthorizationDTO);

    /**
     * 通过角色Id查询同级别用户
     *
     * @param roleId 角色id
     * @return 同级别用户信息
     */
    @RequestMapping(value = BASE_URL + "/selectUserByRoleId", method = RequestMethod.GET)
    ResponseDzz<List<BsAdminUserBO>> selectUserByRoleId(@RequestParam("roleId") String roleId);

    /**
     * 撤销用户
     *
     * @param userCancellationDTO 用户撤销实体
     * @return 撤销结果
     */
    @RequestMapping(value = BASE_URL + "/closeUserAccount", method = RequestMethod.POST)
    ResponseDzz<String> closeUserAccount(@RequestBody UserCancellationDTO userCancellationDTO);

    /**
     * 根据部门id和角色类型查询其人员
     *
     * @param departmentId 部门id
     * @param roleType     角色类型
     * @return 员工数据
     */
    @RequestMapping(value = BASE_URL + "/selectConfigurableUser", method = RequestMethod.GET)
    ResponseDzz<List<BsAdminUserBO>> selectConfigurableUser(@RequestParam("departmentId") String departmentId,
            @RequestParam("roleType") Integer roleType);

    /**
     * 根据部门id和角色类型,用户id查询相关人员
     *
     * @param departmentId 部门id
     * @param roleType     角色类型
     * @param userId       userId
     * @return 员工数据
     */
    @RequestMapping(value = BASE_URL + "/selectConfigurableUserBelong", method = RequestMethod.GET)
    ResponseDzz<List<BsAdminUserBelongBO>> selectConfigurableUserBelong(
            @RequestParam("departmentId") String departmentId,
            @RequestParam("roleType") Integer roleType,
            @RequestParam("userId") String userId);

    /**
     * 根据用户id, 查询其已被配置的上,下级关系人员信息
     *
     * @param userId 用户id
     * @return 上\下级员工数据
     */
    @RequestMapping(value = BASE_URL + "/selectConfiguredUser", method = RequestMethod.GET)
    ResponseDzz<ConfigurableUserBO> selectConfiguredUser(@RequestParam("userId") String userId);

    /**
     * 保存用户的归属关系配置
     *
     * @param userBelongAddDTO 归属关系配置
     * @return 配置结果
     */
    @RequestMapping(value = BASE_URL + "/saveUserAscription", method = RequestMethod.POST)
    ResponseDzz<String> saveUserAscription(@RequestBody UserBelongAddDTO userBelongAddDTO);

    /**
     * 根据邮箱查找用户信息
     *
     * @param mail 邮箱地址
     * @return 配置结果
     */
    @RequestMapping(value = BASE_URL + "/getUserByMail", method = RequestMethod.GET)
    ResponseDzz<BsAdminUserBO> getUserByMail(@RequestParam("mail") String mail);


    /**
     * 根据用户ID取用户信息
     *
     * @param userId 用户Id
     * @return 用户信息
     */
    @RequestMapping(value = BASE_URL + "/selectByUserId", method = RequestMethod.GET)
    ResponseDzz<AdminUserDetailBO> selectByUserId(@RequestParam("userId") String userId);

    /**
     * 根据用户账号取用户信息
     *
     * @param account 用户账号
     * @return 用户信息
     */
    @RequestMapping(value = BASE_URL + "/selectByAccount", method = RequestMethod.GET)
    ResponseDzz<AdminUserDetailBO> selectByAccount(@RequestParam("account") String account);
    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 更新是否成功
     */
    @RequestMapping(value = BASE_URL + "/updateUser", method = RequestMethod.POST)
    ResponseDzz<Boolean> updateUser(@RequestBody BsUserUpdateDTO user);

    /**
     * 更新用户状态
     *
     * @param userId   用户Id
     * @param status   状态信息
     * @param userCode 更新人
     * @return 更新成功与否
     */
    @RequestMapping(value = BASE_URL + "/updateUserStatus", method = RequestMethod.POST)
    ResponseDzz<Boolean> updateUserStatus(@RequestParam("status") String status,
            @RequestParam("userId") String userId,
            @RequestParam("userCode") String userCode);

    /**
     * 验证用户是否存在
     *
     * @param userId 用户Id
     * @return 用户是否存在
     */
    @RequestMapping(value = BASE_URL + "/isExist", method = RequestMethod.GET)
    ResponseDzz<Boolean> isExist(@RequestParam("userId") String userId);

    /**
     * 修改密码
     *
     * @param userId   用户Id
     * @param password 密码
     * @return 更新成功与否
     */
    @RequestMapping(value = BASE_URL + "/updatePassword", method = RequestMethod.POST)
    ResponseDzz<Boolean> updatePassword(@RequestParam("userId") String userId,
            @RequestParam("password") String password);

    /**
     * 验证用户密码是否正确
     * @param password 密码
     * @param userAccount 用户账户
     * @param oldPassword 用户原密码
     * @return 正确data返回true, 错误返回false
     */
    @RequestMapping(value = BASE_URL+ "/checkPassword",method = RequestMethod.GET)
    ResponseDzz<Boolean> checkPassword(@RequestParam("password") String password,
            @RequestParam("userAccount") String userAccount,
            @RequestParam("oldPassword") String oldPassword);

    /**
     * 根据部门id, 查询本部门所有人员
     * @param departmentId 部门id
     * @return 人员信息
     */
    @RequestMapping(value = BASE_URL + "/selectUserByDepartmentId",method = RequestMethod.GET)
    ResponseDzz<List<BsAdminUserBO>> selectUserByDepartmentId(@RequestParam("departmentId") String departmentId);
}