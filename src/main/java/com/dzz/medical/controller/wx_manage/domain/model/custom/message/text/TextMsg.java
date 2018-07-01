package com.dzz.medical.controller.wx_manage.domain.model.custom.message.text;

import com.dzz.medical.controller.wx_manage.domain.model.custom.message.Message;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class TextMsg extends Message {

	private static final long serialVersionUID = 1L;
	
	/** 文本消息信息 */
	private Text text;
}