package com.dzz.medical.controller.system.domain.dto.user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 用户授权
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 13点57分
 */
@Data
public class UserAuthorizationDTO implements Serializable{

    private static final long serialVersionUID = 4999166672504439358L;

    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;

    @ApiModelProperty(name = "userPermitDTOList",value = "用户权限列表")
    private List<UserPermitDTO> userPermitDTOList;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;
}
