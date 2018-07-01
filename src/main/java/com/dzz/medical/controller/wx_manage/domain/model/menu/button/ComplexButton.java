package com.dzz.medical.controller.wx_manage.domain.model.menu.button;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class ComplexButton extends Button {
	
	/** 子菜单项数组 */
	private Button[] sub_button;
}