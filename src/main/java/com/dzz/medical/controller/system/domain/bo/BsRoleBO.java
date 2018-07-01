package com.dzz.medical.controller.system.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色查询BO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日14点38分
 */
@Data
public class BsRoleBO implements Serializable {

    private static final long serialVersionUID = -2180281732518943976L;

    @ApiModelProperty(name = "roleId",value = "角色id")
    private String roleId;

    @ApiModelProperty(name="roleType", value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(name = "name",value = "角色名称")
    private String name;

    @ApiModelProperty(name = "departmentId",value = "部门id")
    private String departmentId;
}
