package com.dzz.medical.controller.wx_manage.common.constant;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述: 微信公众平台URL提供者<br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2016.05.20
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class WXUrlDataProvider {

	private static final Logger log = LoggerFactory.getLogger(WXUrlDataProvider.class);
	
	/**
	 * 微信OAuth2.0网页授权, 获取code参数
	 */
	public static String getOAuth2CodeRequestUrl(String appId, String redirect_uri, String scope, String state) {
		// 服务地址
		String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
		// 设置参数
		oauth2Url = oauth2Url.replace("APPID", urlEnodeUTF8(appId));
		oauth2Url = oauth2Url.replace("REDIRECT_URI", urlEnodeUTF8(redirect_uri));
		oauth2Url = oauth2Url.replace("SCOPE", urlEnodeUTF8(scope));
		oauth2Url = oauth2Url.replace("STATE", urlEnodeUTF8(state));
		return oauth2Url;
	}
	
	/**
	 * 微信OAuth2.0网页授权, 通过code参数换取access_token
	 */
	public static String getOAuth2AccessTokenRequestUrl(String appId, String secret, String code) {
		// 服务地址
		String oauth2AccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		// 设置参数
		oauth2AccessTokenUrl = oauth2AccessTokenUrl.replace("APPID", urlEnodeUTF8(appId));
		oauth2AccessTokenUrl = oauth2AccessTokenUrl.replace("SECRET", urlEnodeUTF8(secret));
		oauth2AccessTokenUrl = oauth2AccessTokenUrl.replace("CODE", urlEnodeUTF8(code));
		return oauth2AccessTokenUrl;
	}

	/**
	 * 获取基础支持中的access_token
	 */
	public static String getBasicSupportAccessTokenRequestUrl(String appId, String secret) {
		// 服务地址
		String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
		// 参数设置
		accessTokenUrl = accessTokenUrl.replace("APPID", urlEnodeUTF8(appId));
		accessTokenUrl = accessTokenUrl.replace("SECRET", urlEnodeUTF8(secret));
		return accessTokenUrl;
	}
	
	/**
	 * 创建自定义菜单
	 */
	public static String getMenuCreateRequestUrl(String access_token) {
		// 菜单创建接口地址(POST) 限100(次/天)  
		String menuCreateUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		// 参数设置
		menuCreateUrl = menuCreateUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		return menuCreateUrl;
	}
	
	/**
	 * 删除自定义菜单
	 */
	public static String getMenuDeleteRequestUrl(String access_token) {
		String menuDelUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
		// 参数设置
		menuDelUrl = menuDelUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		return menuDelUrl;
	}
	
	/** 
	 * 网页授权获取用户基本信息
	 */
	public static String getSnsUserInfoRequestUrl(String access_token, String openId) {
		// 服务地址
		String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		// 设置参数
		userInfoUrl = userInfoUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		userInfoUrl = userInfoUrl.replace("OPENID", urlEnodeUTF8(openId));
		return userInfoUrl;
	}
	
	/**
	 * 获取jsapi_ticket
	 */
	public static String getJsTicketRequestUrl(String access_token) {
		// 服务地址
		String jsTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
		// 设置请求参数
		jsTicketUrl = jsTicketUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		
		return jsTicketUrl;
	}
	
	/**
	 * 获取二维码ticket
	 */
	public static String getQrCodeTicketRequestUrl(String access_token) {
		// 服务地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
		// 参数替换
		requestUrl = requestUrl.replace("TOKEN", urlEnodeUTF8(access_token));
		return requestUrl;
	}
	
	/**
	 * 通过ticket换取二维码
	 */
	public static String getQrCodeByTicketRequestUrl(String ticket) {
		// 服务地址
		String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
		// 参数替换
		requestUrl = requestUrl.replace("TICKET", urlEnodeUTF8(ticket));
		return requestUrl;
	}
	
	/**
	 * 临时素材上传接口服务地址 
	 */
	public static String getMediaUploadUrl(String access_token, String type) {
		// 服务地址
		String uploadUrl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
		// 参数替换
		uploadUrl = uploadUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		uploadUrl = uploadUrl.replace("TYPE", urlEnodeUTF8(type));
		return uploadUrl;
	}
	
	/**
	 * 临时素材下载接口服务地址
	 */
	public static String getMediaDownloadUrl(String access_token, String mediaId) {
		// 服务地址
		String downloadUrl = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		// 参数替换
		downloadUrl = downloadUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		downloadUrl = downloadUrl.replace("MEDIA_ID", urlEnodeUTF8(mediaId));
		return downloadUrl;
	}
	
	/**
	 * 永久素材上传接口服务地址 
	 */
	public static String getMaterialMediaUploadUrl(String access_token, String type) {
		// 服务地址
		String uploadUrl = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
		// 参数替换
		uploadUrl = uploadUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		uploadUrl = uploadUrl.replace("TYPE", urlEnodeUTF8(type));
		return uploadUrl;
	}
	
	/**
	 * 永久素材下载接口服务地址
	 */
	public static String getMaterialMediaDownloadUrl(String access_token, String mediaId) {
		// 服务地址
		String downloadUrl = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		// 参数替换
		downloadUrl = downloadUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		downloadUrl = downloadUrl.replace("MEDIA_ID", urlEnodeUTF8(mediaId));
		return downloadUrl;
	}
	
	/**
	 * 通过OpenID来获取用户基本信息(包括UnionID机制)
	 */
	public static String getUserInfoRequestUrl(String access_token, String openId) {
		// 服务地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		// 参数替换
		requestUrl = requestUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		requestUrl = requestUrl.replace("OPENID", urlEnodeUTF8(openId));
		return requestUrl;
	}
	
	/**
	 * 添加客服帐号接口地址
	 */
	public static String getCustomServiceAddAccountUrl(String access_token) {
		// 服务地址
		String requestUrl = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
		// 参数替换
		requestUrl = requestUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		return requestUrl;
	}
	
	/**
	 * 修改客服帐号接口地址
	 */
	public static String getCustomServiceUpdateAccountUrl(String access_token) {
		// 服务地址
		String requestUrl = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
		// 参数替换
		requestUrl = requestUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		return requestUrl;
	}
	
	/**
	 * 删除客服帐号接口地址
	 */
	public static String getCustomServiceDelAccountUrl(String access_token) {
		// 服务地址
		String requestUrl = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
		// 参数替换
		requestUrl = requestUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		return requestUrl;
	}
	
	/**
	 * 设置客服帐号的头像接口地址
	 */
	public static String getCustomServiceUploadHeadImgUrl(String access_token, String kf_account) {
		// 服务地址
		String requestUrl = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
		// 参数替换
		requestUrl = requestUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		requestUrl = requestUrl.replace("KFACCOUNT", urlEnodeUTF8(kf_account));
		return requestUrl;
	}
	
	/**
	 * 客服发送消息接口地址
	 */
	public static String getCustomServiceSendMsgUrl(String access_token) {
		// 服务地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
		// 参数替换
		requestUrl = requestUrl.replace("ACCESS_TOKEN", urlEnodeUTF8(access_token));
		return requestUrl;
	}
	
	/**
	 * 对URL中的参数进行UTF-8编码
	 */
	public static String urlEnodeUTF8(String parameter) {
		String result = null;
		try {
			result = URLEncoder.encode(parameter, "UTF-8");
		} catch (Exception e) {
			log.error("Url encode error.");
		}
		return result;
	}
	
	/**
	 * 获取当前应用域名
	 */
	public static String getProtocolUrl(HttpServletRequest request) {
		if (request == null) return "";
		String protocolUrl = request.getScheme() + "://" + request.getServerName();
		// 端口号
		int serverPort = request.getServerPort();
		if (serverPort != 80) {
			protocolUrl += ":" + serverPort;
		}
		protocolUrl += request.getContextPath();
		return protocolUrl;
	}
}