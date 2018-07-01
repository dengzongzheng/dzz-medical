package com.dzz.medical.controller.wx_manage.domain.model.token;

import com.dzz.medical.controller.wx_manage.domain.model.base.BaseResult;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class Token extends BaseResult {

	/** 获取到的凭证 */
	private int expires_in;
	
	/** 凭证有效时间, 单位: 秒 */
	private String access_token;
}