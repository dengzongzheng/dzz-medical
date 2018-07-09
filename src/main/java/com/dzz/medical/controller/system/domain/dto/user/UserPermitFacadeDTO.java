package com.dzz.medical.controller.system.domain.dto.user;


import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * 用户授权DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月24 下午4:38
 */
@Data
@Accessors(chain = true)
public class UserPermitFacadeDTO implements Serializable {

    private static final long serialVersionUID = -1804363832663097648L;

    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;

    @ApiModelProperty(name = "userPermitDTOList",value = "用户权限列表")
    private List<UserPermitDTO> userPermitDTOList;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;

    /**
     * 转换成UserAuthorizationDTO
     * @return UserAuthorizationDTO
     */
    public UserAuthorizationDTO convertToUserAuthorizationDTO() {

        UserAuthorizationDTO userAuthorizationDTO = new UserAuthorizationDTO();
        BeanUtils.copyProperties(this, userAuthorizationDTO);
        userAuthorizationDTO
                .setUserPermitDTOList(this.userPermitDTOList.stream().distinct().collect(Collectors.toList()));

        return userAuthorizationDTO;
    }
}
