package com.dzz.medical.controller.system.domain.dto.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * 用户新增DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月23 下午5:38
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddFacadeDTO implements Serializable{

    private static final long serialVersionUID = -8412298787538711430L;

    @ApiModelProperty(name = "userId",value = "用户Id")
    private String userId;

    @ApiModelProperty(name = "userName",value = "用户昵称")
    private String userName;

    @ApiModelProperty(name = "account",value = "用户账户")
    private String account;

    @ApiModelProperty(name = "password",value = "密码")
    private String password;

    @ApiModelProperty(name = "mobile",value = "手机号")
    private String mobile;

    @ApiModelProperty(name = "email",value = "邮箱地址")
    private String email;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;

    @ApiModelProperty(name = "status",value = "用户状态")
    private Integer status;

    @ApiModelProperty(name = "userAscriptionAddDTO",value = "用户归属关系配置DTO")
    private UserBelongAddFacadeDTO userBelongAddDTO;

    /**
     * 转换成BsUserAddDTO
     * @return BsUserAddDTO
     */
    public BsUserAddDTO convertToBsUserAddDTO() {

        BsUserAddDTO bsUserAddDTO = new BsUserAddDTO();
        BeanUtils.copyProperties(this, bsUserAddDTO);
        bsUserAddDTO.setUserBelongAddDTO(userBelongAddDTO.convertToUserBelongAddDTO());
        return bsUserAddDTO;
    }

}
