package com.dzz.medical.controller.system.domain.dto.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户撤销实体
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 14点56分
 */
@Data
public class UserCancellationDTO implements Serializable {

    private static final long serialVersionUID = -7470723835343566454L;

    @ApiModelProperty(name = "userCode", value = "操作人code")
    private String userCode;

    @ApiModelProperty(name = "closedUserId",value = "被撤销的用户id")
    private String closedUserId;

    @ApiModelProperty(name = "assignUserId",value = "被指定的用户Id")
    private String assignUserId;

    @ApiModelProperty(name = "roleId",value = "角色Id")
    private String roleId;

    @ApiModelProperty(name = "roleType", value = "角色类型")
    private Integer roleType;
}
