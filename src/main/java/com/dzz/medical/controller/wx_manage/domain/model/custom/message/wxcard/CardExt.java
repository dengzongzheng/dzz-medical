package com.dzz.medical.controller.wx_manage.domain.model.custom.message.wxcard;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class CardExt {
	
	/** 指定的卡券code码, 只能被领一次 */
	private String code;
	
	/** 指定领取者的openid, 只有该用户能领取 */
	private String openid;
	
	/** 时间戳, 商户生成从1970年1月1日00:00:00至今的秒数, 即当前的时间, 且最终需要转换为字符串形式; 由商户生成后传入, 不同添加请求的时间戳须动态生成, 若重复将会导致领取失败 */
	private String timestamp;
	
	/** 签名, 商户将接口列表中的参数按照指定方式进行签名, 签名方式使用SHA1, 具体签名方案参见下文; 由商户按照规范签名后传入 */
	private String signature;
}