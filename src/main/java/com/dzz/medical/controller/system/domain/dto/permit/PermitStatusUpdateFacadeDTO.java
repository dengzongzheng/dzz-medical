package com.dzz.medical.controller.system.domain.dto.permit;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 权限菜单更新实体
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年04月25 上午9:34
 */
@Data
@Accessors(chain = true)
public class PermitStatusUpdateFacadeDTO implements Serializable{

    private static final long serialVersionUID = 7588058401224304970L;

    private  String permitId;

    private String status;
}
