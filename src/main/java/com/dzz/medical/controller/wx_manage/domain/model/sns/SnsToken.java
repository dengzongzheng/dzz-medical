package com.dzz.medical.controller.wx_manage.domain.model.sns;

import com.dzz.medical.controller.wx_manage.domain.model.base.BaseResult;
import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class SnsToken extends BaseResult {

	/** 网页授权接口调用凭证 */
	private String access_token;

	/** access_token接口调用凭证超时时间, 单位(秒) */
	private Integer expires_in;

	/** 用户刷新access_token */
	private String refresh_token;

	/** 用户唯一标识, 请注意, 在未关注公众号时, 用户访问公众号的网页, 也会产生一个用户和公众号唯一的OpenID */
	private String openid;

	/** 用户授权的作用域, 使用逗号(,)分隔 */
	private String scope;
}