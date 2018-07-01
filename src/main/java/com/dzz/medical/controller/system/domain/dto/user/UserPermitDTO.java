package com.dzz.medical.controller.system.domain.dto.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户权限
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 14点02分
 */
@Data
public class UserPermitDTO implements Serializable {

    private static final long serialVersionUID = 6695764381009044399L;

    @ApiModelProperty(name = "permitId",value = "权限id")
    private String permitId;
}
