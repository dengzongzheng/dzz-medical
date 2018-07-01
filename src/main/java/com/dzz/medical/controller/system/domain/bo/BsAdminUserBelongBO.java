package com.dzz.medical.controller.system.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 查询用户ＢＯ（包含归属关系）
 *
 * @author 连清清
 * @version 1.0.0
 * @since 2018年4月23日 14点31分
 */
@Data
public class BsAdminUserBelongBO extends BsAdminUserBO implements Serializable {

    @ApiModelProperty(name = "isBelong",value = "是否存在归属关系true是false不是")
    private Boolean isBelong;

}
