package com.dzz.medical.controller.system.domain.dto.role;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色新增传输实体
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月23 下午2:13
 */
@Data
@Accessors(chain = true)
public class RoleAddFacadeDTO implements Serializable{

    private static final long serialVersionUID = -3400841231243822576L;

    @ApiModelProperty(name="departmentId",value = "部门Id")
    private String departmentId;

    @ApiModelProperty(name = "roleType",value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(name="name",value = "角色名称")
    private String name;
}
