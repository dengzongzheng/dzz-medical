package com.dzz.medical.controller.wx_manage.domain.model.custom.message.mpnews;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class MpNews {
	
	/** 发送的图文消息(点击跳转到图文消息页)的媒体ID */
	private String media_id;
}