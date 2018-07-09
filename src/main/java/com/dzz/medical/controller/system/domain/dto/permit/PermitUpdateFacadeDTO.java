package com.dzz.medical.controller.system.domain.dto.permit;


import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * 权限菜单修改DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月25 上午9:41
 */
@Data
@Accessors(chain = true)
public class PermitUpdateFacadeDTO implements Serializable{

    private static final long serialVersionUID = -1899257387443198048L;


    @ApiModelProperty(name = "permitId", value = "permitId,更新时必填")
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

    /**
     * 转换成BsAdminPermitDTO
     * @return BsAdminPermitDTO
     */
    public BsAdminPermitDTO convertToBsAdminPermitDTO() {

        BsAdminPermitDTO bsUserAddDTO = new BsAdminPermitDTO();
        BeanUtils.copyProperties(this, bsUserAddDTO);
        return bsUserAddDTO;
    }
}
