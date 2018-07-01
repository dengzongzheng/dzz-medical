package com.dzz.medical.controller.wx_manage.domain.model.custom.message.news;


import com.dzz.medical.controller.wx_manage.domain.model.custom.message.Message;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class NewsMsg extends Message {

	private static final long serialVersionUID = 1L;
	
	/** 图文消息信息 */
	private News news;
}