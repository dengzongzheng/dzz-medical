package com.dzz.medical.controller.system.domain.dto.department;

import com.dzz.medical.controller.system.domain.model.BsAdminDepartment;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 部门新增DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月20 下午4:34
 */
@Data
@Slf4j
public class DepartmentAddDTO implements Serializable{

    private static final long serialVersionUID = 6042797232646856546L;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String name;

    @ApiModelProperty(name = "parentDepartmentId",value = "上级部门Id.最高级部门上线Id为0")
    private String parentDepartmentId;

    @ApiModelProperty(name = "userCode",value = "操作人code")
    private String userCode;

    @ApiModelProperty(name = "departmentPermitDTOList",value = "部门权限")
    private List<DepartmentPermitDTO> departmentPermitDTOList;

    public BsAdminDepartment convertToBsAdminDepartment(Long id,String departmentId){
        BsAdminDepartment obj=new BsAdminDepartment();
        Date date=new Date();
        BeanUtils.copyProperties(this,obj);
        obj.setCreateTime(date);
        obj.setUpdateTime(date);
        obj.setId(id);
        obj.setDepartmentId(departmentId);
        obj.setCreator(this.userCode);
        obj.setUpdator(this.userCode);
        obj.setStatus(1);
        return obj;
    }
}
