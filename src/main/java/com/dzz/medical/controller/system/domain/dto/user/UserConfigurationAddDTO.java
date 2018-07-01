package com.dzz.medical.controller.system.domain.dto.user;

import com.dzz.medical.controller.system.domain.model.BsAdminUserBelong;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 配置用户归属用户数据
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月23日 17点10分
 */
@Data
public class UserConfigurationAddDTO implements Serializable {

    private static final long serialVersionUID = 336648659998706135L;

    @ApiModelProperty(name = "userId",value = "用户id账户")
    private String userId;

    public BsAdminUserBelong convertToBsAdminUserBelong(Long id, String userCode){
        BsAdminUserBelong record = new BsAdminUserBelong();
        Date date=new Date();
        record.setId(id);
        record.setStatus(1);
        record.setUpdateTime(date);
        record.setUpdator(userCode);
        record.setCreateTime(date);
        record.setCreator(userCode);
        return record;
    }

}
