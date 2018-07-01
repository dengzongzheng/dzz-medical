package com.dzz.medical.controller.system.domain.dto.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户列表查询DTO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 11点06分
 */
@Data
public class ListUserQueryDTO implements Serializable {

    private static final long serialVersionUID = 5333713689627288634L;

    @ApiModelProperty(name = "departmentName",value = "部门名称")
    private String departmentName;

    @ApiModelProperty(name = "departmentId",value = "部门id")
    private String departmentId;

    @ApiModelProperty(name = "roleName",value = "角色名称")
    private String roleName;

    @ApiModelProperty(name = "currentUser",value = "用于过滤当前登录用户")
    private String currentUser;

    @ApiModelProperty(name = "pageNo", value = "当前页")
    private Integer pageNo;

    @ApiModelProperty(name = "pageSize", value = "每页条数")
    private Integer pageSize;
}
