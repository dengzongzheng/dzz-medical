package com.dzz.medical.controller.system.domain.dto.permit;


import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

/**
 * 菜单新增DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月25 上午9:16
 */
@Data
@Accessors(chain = true)
public class PermitAddFacadeDTO implements Serializable{

    private static final long serialVersionUID = 5323814977949624205L;

    /**菜单名称*/
    @NotBlank(message = "菜单名称不能为空")
    private String text;

    /**菜单数据*/
    private String data;

    /**菜单父级Id*/
    //@NotEmpty(message = "菜单父级Id不能为空")
    private String parentPermitId;

    /**菜单类型1：菜单，2：按钮*/
    @Min(value = 1,message = "菜单类型不能为空")
    private Integer permitType;

    /**菜单icon*/
    private String icon;

    /**是否为末级菜单*/
    @Max(value = 1,message = "是否为末级菜单不能为空")
    private Integer extremity;

    /**排序字段*/
    private Integer sortNo;

    /**菜单url*/
    private String url;


    /**
     * 转换成新权限体系实体
     * @return BsAdminPermit
     */
    public BsAdminPermitDTO convertToBsAdminPermit() {

        BsAdminPermitDTO bsAdminPermitDTO = new BsAdminPermitDTO();
        BeanUtils.copyProperties(this, bsAdminPermitDTO);
        return bsAdminPermitDTO;
    }

}
