package com.dzz.medical.controller.system.domain.dto.department;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 部门编辑DT哦
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 10点58分
 */
@Data
public class DepartmentUpdateDTO implements Serializable{

    private static final long serialVersionUID = -6395252839518730252L;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String name;

    @ApiModelProperty(name = "departmentId",value = "部门id")
    private String departmentId;

    @ApiModelProperty(name = "parentDepartmentId",value = "上级部门Id.最高级部门上线Id为0")
    private String parentDepartmentId;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;

    @ApiModelProperty(name = "departmentPermitDTOList",value = "部门权限")
    private List<DepartmentPermitDTO> departmentPermitDTOList;
}
