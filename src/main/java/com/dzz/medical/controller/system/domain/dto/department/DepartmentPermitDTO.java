package com.dzz.medical.controller.system.domain.dto.department;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 部门权限DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午5:59
 */
@Data
@Accessors(chain = true)
public class DepartmentPermitDTO implements Serializable{

    private static final long serialVersionUID = 6452484225581885875L;

    @ApiModelProperty(name = "permitId",value = "权限id")
    private String permitId;
}
