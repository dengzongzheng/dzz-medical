package com.dzz.medical.controller.wx_manage.common.constant;

/**
 * 描述: 微信公众平台客服消息发送场景数据提供者</br>
 *
 * @author Shangxp
 * @version 1.0.0
 * @date 2016年6月15日 上午11:46:23
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class SceneTypeDataProvider {
	
	/**
	 * 场景类型: 关注公众号
	 */
	public static final String SCENCE_TYPE_SUBSCRIBE = "0";
	
	/**
	 * 场景类型: 理赔申请-初审通过
	 */
	public static final String SCENCE_BUSI_CLIPASSED = "1";

	/**
	 * 场景类型: 理赔申请-初审未通过
	 */
	public static final String SCENCE_BUSI_CLIREJECT = "2";

	/**
	 * 场景类型: 报案申请-审核通过
	 */
	public static final String SCENCE_BUSI_FNOLPASSED = "3";

	/**
	 * 场景类型: 报案申请-审核未通过
	 */
	public static final String SCENCE_BUSI_FNOLREJECT = "4";

}