package com.dzz.medical.controller.system.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色列表查询BO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 10点05分
 */
@Data
public class ListRoleBO implements Serializable {

    private static final long serialVersionUID = 8553147099805203109L;

    @ApiModelProperty(name = "roleId", value = "角色id")
    private String roleId;

    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    @ApiModelProperty(name = "departmentId", value = "部门id")
    private String departmentId;

    @ApiModelProperty(name = "departmentName", value = "部门名称")
    private String departmentName;

    @ApiModelProperty(name = "createTime",value = "角色创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

}
