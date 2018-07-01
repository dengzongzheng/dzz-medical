package com.dzz.medical.controller.wx_manage.domain.model.base;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class BaseResult {

	private static final String SUCCESS_CODE = "0";

	/** 错误代码 */
	private String errcode;

	/** 错误消息 */
	private String errmsg;

}