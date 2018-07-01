package com.dzz.medical.controller.wx_manage.api;


import com.dzz.medical.controller.wx_manage.common.constant.ConstantDataProvider;
import com.dzz.medical.controller.wx_manage.common.constant.WXUrlDataProvider;
import com.dzz.medical.controller.wx_manage.domain.model.sns.SnsToken;
import com.dzz.medical.controller.wx_manage.domain.model.user.UserInfo;

/**
 * 描述: 微信网页授权接口</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @since 2016年5月20日 下午2:34:58
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class SnsAPI extends BaseAPI {

	/**
	 * 通过code换取网页授权access_token
	 * 
	 * @param appId 微信公众号appID
	 * @param appSecret 微信公众号appSecret
	 * @param code 微信网页授权code参数
	 * @return
	 */
	public static SnsToken getOAuth2AccessTokenByCode(String appId, String appSecret, String code) {
		// 接口地址
		String access_token_url = WXUrlDataProvider.getOAuth2AccessTokenRequestUrl(appId, appSecret, code);
		// 发送请求
		return sendSSLGetRequest(access_token_url, SnsToken.class);
	}
	
	/**
	 * 获取网页授权URL
	 * 
	 * @param appId 微信公众号appID
	 * @param redirect_uri 网页授权回调URL
	 * @param snsapi_userinfo 授权作用域
	 * @param state 重定向后会带上state参数, 开发者可以填写a-zA-Z0-9的参数值, 最多128字节
	 * @return
	 */
	public static String getOAuth2AuthorizeUrl(String appId, String redirect_uri, boolean snsapi_userinfo, String state) {
		// 授权作用域
		String scope = snsapi_userinfo ? ConstantDataProvider.OAUTH2_SCOPE_SNSAPI_USERINFO : ConstantDataProvider.OAUTH2_SCOPE_SNSAPI_BASE;
		String authorizeUrl = WXUrlDataProvider.getOAuth2CodeRequestUrl(appId, redirect_uri, scope, state);
		return authorizeUrl;
	}
	
	/**
	 * 获取用户信息
	 * 
	 * @param access_token 网页授权接口调用凭证(此access_token与基础支持的access_token不同)
	 * @param openid 用户的唯一标识
	 * @return 用户信息
	 */
	public static UserInfo getSnsUserInfo(String access_token, String openid) {
		// 接口地址
		String sns_user_info_url = WXUrlDataProvider.getSnsUserInfoRequestUrl(access_token, openid);
		// 发送请求
		return sendSSLGetRequest(sns_user_info_url, UserInfo.class);
	}
}