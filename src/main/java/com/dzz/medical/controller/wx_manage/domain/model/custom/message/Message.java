package com.dzz.medical.controller.wx_manage.domain.model.custom.message;

import java.io.Serializable;
import lombok.Data;


/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 普通用户OPENID */
	private String touser;

	/** 消息类型 */
	private String msgtype;

}