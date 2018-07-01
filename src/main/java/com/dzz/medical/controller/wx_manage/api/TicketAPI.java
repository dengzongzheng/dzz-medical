package com.dzz.medical.controller.wx_manage.api;


import com.dzz.medical.controller.wx_manage.common.constant.WXUrlDataProvider;
import com.dzz.medical.controller.wx_manage.domain.model.ticket.JsTicket;

/**
 * 描述: 微信JS接口</br>
 *
 * @author Shangxp
 * @version 1.0.0
 * @date 2016年5月20日 下午5:08:52
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class TicketAPI extends BaseAPI {

	/**
	 * 获取jsapi_ticket
	 * 
	 * @param access_token
	 * @return
	 */
	public static JsTicket getJsApiTicket(String access_token) {
		// 接口地址
		String ticket_url = WXUrlDataProvider.getJsTicketRequestUrl(access_token);
		// 发送请求
		return sendSSLGetRequest(ticket_url, JsTicket.class);
	}
}