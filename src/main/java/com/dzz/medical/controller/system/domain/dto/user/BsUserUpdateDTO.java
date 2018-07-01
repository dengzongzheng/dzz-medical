package com.dzz.medical.controller.system.domain.dto.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户更新实体
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月24日11点41分
 */
@Data
public class BsUserUpdateDTO implements Serializable {

    private static final long serialVersionUID = -2391434133883670331L;
    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;

    @ApiModelProperty(name = "userName",value = "用户昵称")
    private String userName;

    @ApiModelProperty(name = "account",value = "用户账户")
    private String account;

    @ApiModelProperty(name = "mobile",value = "手机号")
    private String mobile;

    @ApiModelProperty(name = "email",value = "邮箱地址")
    private String email;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;

    @ApiModelProperty(name = "status",value = "用户状态")
    private Integer status;
}
