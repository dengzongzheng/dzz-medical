package com.dzz.medical.controller.system.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户列表查询BO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 10点46分
 */
@Data
public class ListUserBO implements Serializable {
    private static final long serialVersionUID = 8319568998413891698L;

    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;

    @ApiModelProperty(name = "departmentId", value = "所属部门id")
    private String departmentId;

    @ApiModelProperty(name = "departmentName", value = "所属部门名称")
    private String departmentName;

    @ApiModelProperty(name = "roleId", value = "角色id")
    private String roleId;

    @ApiModelProperty(name = "roleName", value = "角色名称")
    private String roleName;

    @ApiModelProperty(name = "roleType",value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(name = "mobile", value = "手机号")
    private String mobile;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(name = "status", value = "状态")
    private Integer status;

    @ApiModelProperty(name = "statusName", value = "状态名称")
    private String statusName;

    @ApiModelProperty(name = "account", value = "用户账号")
    private String account;

    @ApiModelProperty(name = "userName",value = "用户真实姓名")
    private String userName;

    public String getStatusName() {
        if (this.status == 1) {
            return "有效";
        } else if (this.status == 0) {
            return "无效";
        } else if (this.status == 2) {
            return "暂存";
        } else {
            return "";
        }
    }
}
