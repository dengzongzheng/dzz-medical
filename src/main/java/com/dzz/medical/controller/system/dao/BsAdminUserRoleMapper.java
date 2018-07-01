package com.dzz.medical.controller.system.dao;

import com.dzz.medical.controller.system.domain.model.BsAdminUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminUserRoleMapper extends Mapper<BsAdminUserRole> {

    /**
     * 更新用户的角色状态数据
     * @param status 状态
     * @param userId 用户id
     * @param userCode 操作人code
     */
    void updateStatus(@Param("status") Integer status, @Param("userId") String userId,
            @Param("userCode") String userCode);

    /**
     * 根据用户id获取用户角色
     * @param userId
     * @return
     */
    BsAdminUserRole getByUserId(@Param("userId") String userId);
}
