package com.dzz.medical.controller.wx_manage.common.utilities.sign;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述: 微信JS-SDK签名工具类</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2015.05.12
 */
public class JSApiSignUtils {

	private static final Logger log = LoggerFactory.getLogger(JSApiSignUtils.class);
	
	/**
	 * 签名方法
	 * 
	 * @param jsapi_ticket
	 * @param url
	 */
	public static Map<String, String> signature(String jsapi_ticket, String url) {
		Map<String, String> map = new HashMap<String, String>();
		// 生成签名的随机串
		String nonce_str = create_nonce_str();
		// 生成签名的时间戳
		String timestamp = create_timestamp();
		// 签名
		String signature = "";

		// 注意这里参数名必须全部小写, 且有序
		String signStr = "jsapi_ticket=" + 
			jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;

		log.info("----- 签名串 -----: " + signStr);

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(signStr.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (Exception e) {
			log.error("获取微信JS-SDK签名错误: " + e.getMessage(), e);
		}
		
		map.put("url", url);
		map.put("jsapi_ticket", jsapi_ticket);
		map.put("nonceStr", nonce_str);
		map.put("timestamp", timestamp);
		map.put("signature", signature);

		return map;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * 生成签名用随机串
	 */
	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 生成签名用时间戳
	 */
	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
}