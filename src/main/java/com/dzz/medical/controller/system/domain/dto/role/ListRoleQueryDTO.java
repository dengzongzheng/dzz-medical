package com.dzz.medical.controller.system.domain.dto.role;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色列表查询DTO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 10点12分
 */
@Data
public class ListRoleQueryDTO implements Serializable {

    private static final long serialVersionUID = 1111908704547990647L;

    @ApiModelProperty(name = "departmentName",value = "部门名称")
    private String departmentName;

    @ApiModelProperty(name = "roleName",value = "角色名称")
    private String roleName;

    @ApiModelProperty(name = "departmentId",value = "部门id")
    private String departmentId;

    @ApiModelProperty(name = "pageNo", value = "当前页")
    private Integer pageNo;

    @ApiModelProperty(name = "pageSize", value = "每页条数")
    private Integer pageSize;
}
