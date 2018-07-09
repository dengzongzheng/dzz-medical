package com.dzz.medical.controller.system.domain.dto.user;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户状态更新DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月24 下午3:09
 */
@Data
@Accessors(chain = true)
public class UserUpdateStatusFacadeDTO implements Serializable{

    private static final long serialVersionUID = -2318904987811147751L;

    private String userId;


    private String status;
}
