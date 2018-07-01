package com.dzz.medical.controller.system.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户详细信息, 包含部门\角色
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月24日15点05分
 */
@Data
public class AdminUserDetailBO implements Serializable {

    private static final long serialVersionUID = -4098160376695320190L;

    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;

    @ApiModelProperty(name = "userName",value = "用户姓名")
    private String userName;

    @ApiModelProperty(name = "account",value = "用户账户")
    private String account;

    @ApiModelProperty(name = "password",value = "密码")
    private String password;

    @ApiModelProperty(name = "mobile",value = "手机号")
    private String mobile;

    @ApiModelProperty(name = "email",value = "邮箱地址")
    private String email;

    @ApiModelProperty(name = "contactName",value = "联系人姓名")
    private String contactName;

    @ApiModelProperty(name = "contactMobile",value = "联系人手机号")
    private String contactMobile;

    @ApiModelProperty(name = "contactEmail",value = "联系人邮箱")
    private String contactEmail;

    @ApiModelProperty(name = "wxId",value = "微信id")
    private String wxId;

    @ApiModelProperty(name = "qq",value = "qq号")
    private String qq;

    @ApiModelProperty(name = "roleId",value = "角色id")
    private String roleId;

    @ApiModelProperty(name="roleType", value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(name = "name",value = "角色名称")
    private String roleName;

    @ApiModelProperty(name = "departmentId",value = "部门id")
    private String departmentId;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String departmentName;

    @ApiModelProperty(name = "status",value = "状态")
    private String status;
}
