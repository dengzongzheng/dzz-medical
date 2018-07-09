package com.dzz.medical.controller.system.domain.dto.user;

import lombok.Data;

/**
 * 修改密码实体DTO
 *
 * @author dzz
 * @since  2017年06月27 下午2:24
 * @version  1.0.0
 */
@Data
public class UpdatePasswordDTO {

    /*原始密码*/
    private String oldPassword;

    /*新密码*/
    private String password;

    /*确认密码*/
    private String confirmPassword;
}
