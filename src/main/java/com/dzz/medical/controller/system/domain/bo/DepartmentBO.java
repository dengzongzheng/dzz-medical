package com.dzz.medical.controller.system.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 部门BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:38
 */
@Data
@Accessors(chain = true)
public class DepartmentBO implements Serializable{

    private static final long serialVersionUID = 4955460065868280055L;

    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    @ApiModelProperty(name = "departmentId",value = "部门Id")
    private String departmentId;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String name;

    @ApiModelProperty(name="parentDepartmentId",value = "上级部门Id.最高级部门上线Id为0")
    private String parentDepartmentId;

    @ApiModelProperty(name = "permitBOList", value = "部门权限信息")
    private List<PermitBO> permitBOList;
}
