package com.dzz.medical.controller.system.domain.dto.department;


import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * 新增部门DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:10
 */
@Data
@Accessors(chain = true)
public class DepartmentAddFacadeDTO implements Serializable {

    private static final long serialVersionUID = -4923637101044119259L;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String name;

    @ApiModelProperty(name = "parentDepartmentId",value = "上级部门Id.最高级部门上线Id为0")
    private String parentDepartmentId;

    @ApiModelProperty(name = "departmentPermitDTOList",value = "部门权限")
    private List<DepartmentPermitDTO> departmentPermitDTOList;

    /**
     * 转换成DepartmentAddDTO
     * @return DepartmentAddDTO
     */
    public DepartmentAddDTO convertToDepartmentAddDTO() {

        DepartmentAddDTO departmentAddDTO = new DepartmentAddDTO();
        BeanUtils.copyProperties(this,departmentAddDTO);
        departmentAddDTO.setDepartmentPermitDTOList(
                this.departmentPermitDTOList.stream().distinct().collect(Collectors.toList()));
        return departmentAddDTO;
    }
}
