package com.dzz.medical.controller.wx_manage.common.constant;

/**
 * 描述: 微信公众平台消息类型数据提供者<br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2016.04.20
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class MsgTypeDataProvider {
	
	/**
	 * 返回消息类型: 文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型: 音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型: 图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 请求消息类型: 文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型: 图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型: 链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型: 地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型: 音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型: 事件(推送)
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型: subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型: unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型: CLICK(点击CLICK类型自定义菜单事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
	
	/**
	 * 事件类型: VIEW(点击VIEW类型自定义菜单事件)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";
	
	/**
	 * 事件类型: SCAN(扫描带参数二维码事件)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

}