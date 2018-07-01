package com.dzz.medical.controller.system.dao;


import com.dzz.medical.controller.system.domain.bo.AdminUserDetailBO;
import com.dzz.medical.controller.system.domain.bo.BsAdminUserBO;
import com.dzz.medical.controller.system.domain.bo.ListUserBO;
import com.dzz.medical.controller.system.domain.dto.user.ListUserQueryDTO;
import com.dzz.medical.controller.system.domain.model.BsAdminUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminUserMapper extends Mapper<BsAdminUser> {
    /**
     * 查询用户列表
     * @param listUserQueryDTO 查询条件
     * @return 用户列表
     */
    List<ListUserBO> pageListDepartment(ListUserQueryDTO listUserQueryDTO);
    /**
     * 根据部门Id查询用户列表
     * @param departmentName 部门名称
     *  @param roleName 角色名称
     * @param departmentId 部门Id
     * @return 用户列表
     */
    List<ListUserBO> pageListDepartmentId(@Param("departmentName") String departmentName,
            @Param("roleName") String roleName,
            @Param("departmentId") String departmentId,
            @Param("currentUser") String currentUser);

    /**
     * 根据角色id查询同级别用户
     * @param roleId roleId
     * @return 结果
     */
    List<BsAdminUserBO> selectUserByRoleId(@Param("roleId") String roleId);

    /**
     *根据userId更新状态
     * @param status 状态
     * @param userId userId
     * @return 结果
     */
    int updateStatus(@Param("status") int status, @Param("userId") String userId,
            @Param("userCode") String userCode);

    /**
     * 根据部门id和角色类型获取用户列表
     * @param departmentId 部门id
     * @param roleType 角色类型
     * @return  列表
     */
    List<BsAdminUserBO> listUsersByParam(@Param("departmentId") String departmentId,
            @Param("roleType") Integer roleType);


    /**
     * 根据邮箱获取用户
     * @param mail 邮箱
     * @return 用户
     */
    BsAdminUserBO getByMail(@Param("mail") String mail);

    /**
     * 根据ID获取用户信息
     * @param userId 用户Id
     * @return 用户信息
     */
    AdminUserDetailBO selectUserDetailByUserId(@Param("userId") String userId);

    /**
     * 根据账户获取用户信息
     * @param account 用户账户
     * @return 用户信息
     */
    AdminUserDetailBO selectUserDetailByAccount(@Param("account") String account);

    /**
     * 通过用户id查询用户
     * @param userId 用户id
     * @return 用户信息
     */
    BsAdminUser selectByUserId(@Param("userId") String userId);

    /**
     * 通过部门id查询用户
     * @param departmentId 部门id
     * @return 用户信息
     */
    List<BsAdminUserBO> selectUserByDepartmentId(@Param("departmentId") String departmentId);
}