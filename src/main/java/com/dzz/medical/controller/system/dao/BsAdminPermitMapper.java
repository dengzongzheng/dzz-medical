package com.dzz.medical.controller.system.dao;


import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.model.BsAdminPermit;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminPermitMapper extends Mapper<BsAdminPermit> {
    /**
     * 通过权限id查询权限
     *
     * @param listPermitId 权限id
     * @return 权限信息
     */
    List<PermitBO> selectByPermitId(@Param("listPermitId") List<String> listPermitId);

    /**
     * 取所有菜单信息
     *
     * @return 菜单列表
     */
    List<PermitBO> listAdminPermit();

    /**
     * 用户菜单权限列表,返回菜单权限实体列表
     *
     * @param userId       用户Id
     * @return 菜单权限列表
     */
    List<PermitBO> listAdminPermitList(@Param("userId") String userId);

    /**
     * 用户所在部门的菜单权限列表,返回菜单权限实体列表
     *
     * @param userId       用户Id
     * @return 菜单权限列表
     */
    List<PermitBO> listAdminPermitListByUserDepartment(@Param("userId") String userId);

    /**
     * 部门菜单权限列表,返回菜单权限实体列表
     *
     * @param departmentId       部门Id
     * @return 菜单权限列表
     */
    List<PermitBO> listAdminPermitListByDepartmentId(@Param("departmentId") String departmentId);
    /**
     * 根据id取菜单信息
     * @param permitId 菜单Id
     * @return 菜单
     */
    PermitBO getAdminPermitById(@Param("permitId") String permitId);

    /**
     * 更新菜单信息
     * @param permitId 菜单Id
     * @param status 状态
     * @return 更新条数
     */
    int updateAdminPermitStatus(@Param("permitId") String permitId, @Param("status") String status);

    /**
     * 根据权限id获取权限信息
     * @param permitId 权限id
     * @return 权限信息
     */
    BsAdminPermit getByPermitId(@Param("permitId") String permitId);

}