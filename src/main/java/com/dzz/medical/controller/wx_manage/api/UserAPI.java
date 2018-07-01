package com.dzz.medical.controller.wx_manage.api;


import com.dzz.medical.controller.wx_manage.common.constant.WXUrlDataProvider;
import com.dzz.medical.controller.wx_manage.domain.model.user.UserInfo;

/**
 * 描述: 微信用户管理接口</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @since 2016年5月20日 下午5:08:52
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class UserAPI extends BaseAPI {

	/**
	 * 获取用户基本信息
	 * 
	 * @param access_token 接口调用凭证
	 * @param openid 用户的唯一标识
	 * @return 用户信息
	 */
	public static UserInfo getUserInfo(String access_token, String openid) {
		// 接口地址
		String user_info_url = WXUrlDataProvider.getUserInfoRequestUrl(access_token, openid);
		// 发送请求
		return sendSSLGetRequest(user_info_url, UserInfo.class);
	}
}