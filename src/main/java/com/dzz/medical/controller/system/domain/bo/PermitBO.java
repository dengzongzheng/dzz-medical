package com.dzz.medical.controller.system.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 权限查询BO
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 19点51分
 */
@Data
public class PermitBO implements Serializable {

    private static final long serialVersionUID = 988215014473966274L;

    @ApiModelProperty(name = "permitId", value = "权限id")
    private String permitId;

    @ApiModelProperty(name = "text", value = "权限名称")
    private String text;

    @ApiModelProperty(name = "platformId",value = "平台id")
    private String platformId;

    @ApiModelProperty(name = "data",value = "菜单数据存放")
    private String data;

    @ApiModelProperty(name = "permitType",value = "权限类型:1菜单、2功能按钮")
    private Integer permitType;

    @ApiModelProperty(name = "parentPermitId",value = "父级权限Id,顶级菜单权限父级Id为0、功能级权限父级Id为其上级菜单权限Id")
    private String parentPermitId;

    @ApiModelProperty(name = "icon",value = "菜单icon")
    private String icon;

    @ApiModelProperty(name = "extremity",value = "菜单权限是否为最后一级 0:否、1是")
    private Integer extremity;

    @ApiModelProperty(name = "sortNo", value = "排序字段")
    private Integer sortNo;

    @ApiModelProperty(name = "url", value = "权限地址")
    private String url;

}
