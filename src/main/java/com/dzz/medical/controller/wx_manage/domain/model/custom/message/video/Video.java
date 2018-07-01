package com.dzz.medical.controller.wx_manage.domain.model.custom.message.video;


import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class Video {
	
	/** 发送的视频消息的媒体ID */
	private String media_id;
	
	/** 缩略图的媒体ID */
	private String thumb_media_id;
	
	/** 视频消息的标题 */
	private String title;
	
	/** 视频消息的描述 */
	private String description;
}