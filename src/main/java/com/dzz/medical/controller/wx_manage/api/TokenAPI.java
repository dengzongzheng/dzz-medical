package com.dzz.medical.controller.wx_manage.api;


import com.dzz.medical.controller.wx_manage.common.constant.WXUrlDataProvider;
import com.dzz.medical.controller.wx_manage.domain.model.token.Token;

/**
 * 描述: 微信基础支持, 公众号全局唯一票据接口</br>
 *
 * @author Shangxp
 * @version 1.0.0
 * @date 2016年5月20日 下午5:08:52
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class TokenAPI extends BaseAPI {
	
	/**
	 * 获取微信基础支持中的access_token
	 * 
	 * @param appId 微信公众号appID
	 * @param appSecret 微信公众号appSecret
	 * @return
	 */
	public static Token getAccessTokenForBasicSupport(String appId, String appSecret) {
		// 接口地址
		String access_token_url = WXUrlDataProvider.getBasicSupportAccessTokenRequestUrl(appId, appSecret);
		// 发送请求
		return sendSSLGetRequest(access_token_url, Token.class);
	}
}