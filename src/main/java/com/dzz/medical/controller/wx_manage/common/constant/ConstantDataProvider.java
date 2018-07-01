package com.dzz.medical.controller.wx_manage.common.constant;

/**
 * 描述: 应用程序静态数据提供者</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2016.05.20
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class ConstantDataProvider {
	
	/** HTTP/HTTPS请求方式  */
	public static final String GET = "GET";
	public static final String POST = "POST";
	
	/** 请求超时时间 */
	public final static int READ_TIMEOUT  	= 15;
	public final static int WRITE_TIMEOUT 	= 15;
	public final static int CONNECT_TIMEOUT = 5;
	
	/** OAuth2.0网页授权Scope类型 */
	public static final String OAUTH2_SCOPE_SNSAPI_BASE = "snsapi_base";
	public static final String OAUTH2_SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";
	
	/** 微信媒体文件类型 */
	public static final String MEDIA_TYPE_IMAGE = "image";
	public static final String MEDIA_TYPE_VOICE = "voice";
	public static final String MEDIA_TYPE_VIDEO = "video";
	public static final String MEDIA_TYPE_THUMB = "thumb";
	
	/** 二维码扫码关注事件KEY值前缀 */
	public static final String QR_SCENE_PREFIX = "qrscene";
	
	/** 错误码 */
	public static final String WX_ERR_CODE_40003 = "40003";
	public static final String WX_ERR_CODE_40007 = "40007";
	public static final String WX_ERR_CODE_40013 = "40013";
}