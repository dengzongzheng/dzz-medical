package com.dzz.medical.controller.wx_manage.domain.model.custom.message.image;

import lombok.Data;

/**
 * 首页相关控制
 * @author dzz
 * @since  2017年06月15 下午8:26
 * @version  1.0.0
 */
@Data
public class Image {
	
	/** 发送的图片消息的媒体ID */
	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
}