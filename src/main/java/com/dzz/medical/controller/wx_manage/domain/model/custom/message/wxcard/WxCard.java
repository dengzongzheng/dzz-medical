package com.dzz.medical.controller.wx_manage.domain.model.custom.message.wxcard;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class WxCard {
	
	/** 卡券ID */
	private String card_id;
	
	/** 卡券扩展字段信息 */
	private CardExt card_ext;
}