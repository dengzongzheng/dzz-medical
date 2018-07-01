package com.dzz.medical.controller.system.domain.dto.user;

import com.dzz.medical.controller.system.domain.model.BsAdminUser;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 新增用户DTO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 11点35分
 */
@Data
public class BsUserAddDTO implements Serializable {

    private static final long serialVersionUID = -3716824091491472784L;

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
    private UserBelongAddDTO userBelongAddDTO;

    public BsAdminUser convertToBsAdminUser(Long id, String userId){
        BsAdminUser obj=new BsAdminUser();
        BeanUtils.copyProperties(this,obj);
        Date date=new Date();
        obj.setCreateTime(date);
        obj.setUpdateTime(date);
        obj.setCreator(this.userCode);
        obj.setUpdator(this.userCode);
        obj.setId(id);
        obj.setUserId(userId);
        return obj;
    }
}
