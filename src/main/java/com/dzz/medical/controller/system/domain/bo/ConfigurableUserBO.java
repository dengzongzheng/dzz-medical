package com.dzz.medical.controller.system.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 查询可配置的上下级人员
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 16点36分
 */
@Data
public class ConfigurableUserBO implements Serializable {

    private static final long serialVersionUID = 6137261178442325898L;

    @ApiModelProperty(name = "higherLevelUsers",value = "上级员工信息")
    private List<BsAdminUserBO> higherLevelUsers;

    @ApiModelProperty(name = "lowerLevelUsers", value = "下属员工信息")
    private List<BsAdminUserBO> lowerLevelUsers;
}
