package com.dzz.medical.controller.system.domain.dto.department;


import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * 部门修改DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午5:04
 */
@Data
@Accessors(chain = true)
public class DepartmentUpdateFacadeDTO implements Serializable{

    private static final long serialVersionUID = -1263453380797290427L;

    @ApiModelProperty(name = "departmentId",value = "部门Id")
    private String departmentId;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String name;

    @ApiModelProperty(name = "parentDepartmentId",value = "上级部门Id.最高级部门上线Id为0")
    private String parentDepartmentId;

    @ApiModelProperty(name = "departmentPermitDTOList",value = "部门权限")
    private List<DepartmentPermitDTO> departmentPermitDTOList;

    /**
     * 转换成DepartmentUpdateDTO
     * @return DepartmentUpdateDTO
     */
    public DepartmentUpdateDTO convertToDepartmentUpdateDTO() {

        DepartmentUpdateDTO departmentUpdateDTO = new DepartmentUpdateDTO();
        BeanUtils.copyProperties(this, departmentUpdateDTO);
        departmentUpdateDTO.setDepartmentPermitDTOList(
                this.departmentPermitDTOList.stream().distinct().collect(Collectors.toList()));
        return departmentUpdateDTO;
    }
}
