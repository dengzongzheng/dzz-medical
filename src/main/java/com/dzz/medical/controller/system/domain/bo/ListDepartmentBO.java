package com.dzz.medical.controller.system.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门列表查询
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月20日18点12分
 */
@Data
public class ListDepartmentBO implements Serializable {

    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    @ApiModelProperty(name = "departmentId",value = "部门Id")
    private String departmentId;

    @ApiModelProperty(name = "name",value = "部门名称")
    private String name;

    @ApiModelProperty(name = "status",value = "状态:1有效数据、2暂存数据、0无效")
    private Integer status;

    @ApiModelProperty(name = "createTime",value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(name = "statusName",value = "状态名称")
    private String statusName;

    @ApiModelProperty(name = "staffQuantity",value = "员工人数")
    private Integer staffQuantity;

    public String getStatusName(){
        if (this.status == 1) {
            return "有效";
        } else if (this.status == 0) {
            return "无效";
        } else if (this.status == 2) {
            return "暂存";
        } else {
            return "";
        }
    }
}
