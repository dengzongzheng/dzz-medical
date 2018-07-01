package com.dzz.medical.controller.wx_manage.domain.model.ticket;

import com.dzz.medical.controller.wx_manage.domain.model.base.BaseResult;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class JsTicket extends BaseResult {

	/** 调用微信JS接口的临时票据, 有效期为7200秒 */
	private String ticket;

	/** 票据有效时间, 单位: 秒 */
	private Integer expires_in;
}