package com.dzz.medical.controller.system.domain.dto.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 用户归属关系添加DTO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 17点07分
 */
@Data
public class UserBelongAddDTO implements Serializable {

    private static final long serialVersionUID = -4735204274677272740L;

    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;


    @ApiModelProperty(name = "userCode",value = "操作人Code")
    private String userCode;

    @ApiModelProperty(name = "roleId",value = "角色Id")
    private String roleId;

    @ApiModelProperty(name = "higherLevelUsers",value = "上级员工信息")
    private List<UserConfigurationAddDTO> higherLevelUsers;

    @ApiModelProperty(name = "lowerLevelUsers", value = "下属员工信息")
    private List<UserConfigurationAddDTO> lowerLevelUsers;

}
