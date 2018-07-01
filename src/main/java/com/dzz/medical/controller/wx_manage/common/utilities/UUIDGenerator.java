package com.dzz.medical.controller.wx_manage.common.utilities;

import java.util.UUID;

/**
 * 描述: 生成UUID</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2017年02月15日
 * 
 * Copyright © 2017 BZN Corporation, All Rights Reserved.
 */
public class UUIDGenerator {
	
	/**
	 * 生成UUID公用业务方法
	 */
	public static String createKey() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 创建32位的UUID
	 */
	public static String create10Key() {
		String uuid = UUID.randomUUID().toString().replaceAll("\\-", "");
		return uuid.substring(22);
	}

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static int createRandom(int length) {
		String retStr = "";
		String strTableFirst = "123456789";
		String strTable = "1234567890";

		for (int i = 0; i < length; i++) {
			if (i == 0) {
				double dblR = Math.random() * 9;
				int intR = (int) Math.floor(dblR);
				retStr += strTableFirst.charAt(intR);
			} else {
				double dblR = Math.random() * 10;
				int intR = (int) Math.floor(dblR);
				retStr += strTable.charAt(intR);
			}
		}
		return Integer.parseInt(retStr);
	}
}