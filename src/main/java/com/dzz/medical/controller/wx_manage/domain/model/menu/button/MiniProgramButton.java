package com.dzz.medical.controller.wx_manage.domain.model.menu.button;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class MiniProgramButton extends ViewButton {

	/** 小程序的appid(仅认证公众号可配置) */
	private String appid;

	/** 小程序的页面路径 */
	private String pagepath;

}