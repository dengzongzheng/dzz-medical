package com.dzz.medical.controller.wx_manage.domain.model.media;

import com.dzz.medical.controller.wx_manage.domain.model.base.BaseResult;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class Media extends BaseResult {

	/** 媒体文件类型 */
	private String type;
	
	/** 媒体文件上传后, 获取时的唯一标识(MediaId) */
	private String media_id;
	
	/** 媒体文件类型为缩略图(thumb)时, 获取时的唯一标识(MediaId) */
	private String thumb_media_id;
	
	/** 媒体文件上传时间戳 */
	private int created_at;
	
	/** 新增的图片素材的图片URL(仅新增永久图片素材时会返回该字段) */
	private String url;

}