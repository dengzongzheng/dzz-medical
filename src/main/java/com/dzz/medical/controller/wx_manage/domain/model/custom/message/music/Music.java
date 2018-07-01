package com.dzz.medical.controller.wx_manage.domain.model.custom.message.music;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class Music {
	
	/** 音乐消息的标题 */
	private String title;
	
	/** 音乐消息的描述 */
	private String description;
	
	/** 音乐链接 */
	private String musicurl;
	
	/** 高品质音乐链接, wifi环境优先使用该链接播放音乐 */
	private String hqmusicurl;
	
	/** 缩略图的媒体ID */
	private String thumb_media_id;
}