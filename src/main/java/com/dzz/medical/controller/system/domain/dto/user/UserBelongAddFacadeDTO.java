package com.dzz.medical.controller.system.domain.dto.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * 归属管理DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月23 下午5:39
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBelongAddFacadeDTO implements Serializable{

    private static final long serialVersionUID = 2353259186089206082L;

    @ApiModelProperty(name = "userId",value = "用户id")
    private String userId;

    @ApiModelProperty(name = "roleId",value = "角色Id")
    private String roleId;

    @ApiModelProperty(name = "departmentId",value = "部门Id")
    private String departmentId;

    @ApiModelProperty(name = "higherLevelUsers",value = "上级员工信息")
    private List<UserConfigurationAddDTO> higherLevelUsers;

    @ApiModelProperty(name = "lowerLevelUsers", value = "下属员工信息")
    private List<UserConfigurationAddDTO> lowerLevelUsers;

    /**
     * 转换成UserBelongAddDTO
     * @return UserBelongAddDTO
     */
    public UserBelongAddDTO convertToUserBelongAddDTO() {

        UserBelongAddDTO bsUserBelongAddDTO = new UserBelongAddDTO();
        BeanUtils.copyProperties(this, bsUserBelongAddDTO);
        return bsUserBelongAddDTO;
    }
}
