package com.dzz.medical.controller.system.domain.dto.role;

import com.dzz.medical.controller.system.domain.model.BsAdminRole;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @角色新增实体DTO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 10点31分
 */
@Data
public class RoleAddDTO implements Serializable {

    private static final long serialVersionUID = -8569575331132970443L;

    @ApiModelProperty(name="departmentId",value = "部门Id")
    private String departmentId;

    @ApiModelProperty(name="name",value = "角色名称")
    private String name;

    @ApiModelProperty(name = "roleType",value = "角色类型")
    private Integer roleType;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;

    public BsAdminRole convertToBsAdminRole(Long id, String roleId){
        BsAdminRole obj=new BsAdminRole();
        BeanUtils.copyProperties(this,obj);
        Date date=new Date();
        obj.setCreateTime(date);
        obj.setUpdateTime(date);
        obj.setStatus(1);
        obj.setId(id);
        obj.setRoleId(roleId);
        obj.setCreator(this.userCode);
        obj.setUpdator(this.userCode);
        return obj;
    }
}
