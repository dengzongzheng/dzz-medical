package com.dzz.medical.controller.wx_manage.domain.model.custom.message.news;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class Article {

	/** 图文消息的标题 */
	private String title;
	
	/** 图文消息的描述 */
	private String description;
	
	/** 图文消息被点击后跳转的链接 */
	private String url;
	
	/** 图文消息的图片链接, 支持JPG、PNG格式, 较好的效果为大图640*320, 小图80*80 */
	private String picurl;
}