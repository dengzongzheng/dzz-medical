package com.dzz.medical.controller.system.dao;


import com.dzz.medical.controller.system.domain.bo.BsAdminUserBO;
import com.dzz.medical.controller.system.domain.model.BsAdminUserBelong;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BsAdminUserBelongMapper extends Mapper<BsAdminUserBelong> {
    /**
     * 根据用户id查询部门领导列表
     * @param userId 用户id
     * @return 部门领导列表
     */
    List<BsAdminUserBO> listHigherLevelUsersByUserId(@Param("userId") String userId);

    /**
     * 根据用户id查询部门下属列表
     * @param userId 用户id
     * @return 部门下属列表
     */
    List<BsAdminUserBO> listLowerLevelUsersByUserId(@Param("userId") String userId);

    /**
     * 查询用户归属信息
     * @param userId 用户id
     * @param subordinateId 下属Id
     * @return 结果
     */
    List<BsAdminUserBO> listBelongByUserId(@Param("userId") String userId, @Param("subordinateId") String subordinateId);

    /**
     * 根据用户id删除上下级归属
     * @param userId
     * @return
     */
    int deleteAllByUserId(@Param("userId") String userId);

    /**
     * 撤销用户变更用户
     * @param userId 用户id
     * @param userCode 操作人code
     * @param assignUserId 指定用户id
     */
    void updateUserId(@Param("userId") String userId,
            @Param("assignUserId") String assignUserId, @Param("userCode") String userCode);

}