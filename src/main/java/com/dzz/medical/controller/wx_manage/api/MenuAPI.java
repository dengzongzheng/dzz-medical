package com.dzz.medical.controller.wx_manage.api;

import com.dzz.medical.controller.wx_manage.common.constant.WXUrlDataProvider;
import com.dzz.medical.controller.wx_manage.common.utilities.adapter.JsonTypeHandlerAdapter;
import com.dzz.medical.controller.wx_manage.domain.model.base.BaseResult;
import com.dzz.medical.controller.wx_manage.domain.model.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 描述: 微信自定义菜单接口</br>
 *
 * @author Shangxp
 * @version 1.0.0
 * @date 2016年5月21日 下午7:22:19
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class MenuAPI extends BaseAPI {
	
	private static final Logger log = LoggerFactory.getLogger(MenuAPI.class);
	
	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param access_token 接口访问凭证
	 * @return 0表示成功, 其他值表示失败
	 */
	public static int createMenu(Menu menu, String access_token) {
		// 接口调用反馈结果
		int result = 1;
		// 创建菜单的URL
		String create_menu_url = WXUrlDataProvider.getMenuCreateRequestUrl(access_token);
		// 将菜单对象转换成json字符串
	    String jsonMenu = JsonTypeHandlerAdapter.getInstance().object2Json(menu);
	    log.info("创建自定义菜单json请求数据:\t\n" + jsonMenu);
	    // 调用接口创建菜单
	    BaseResult baseResult = sendSSLPostRequest(create_menu_url, jsonMenu, BaseResult.class);
	    if (baseResult != null) {
	    	result = Integer.valueOf(baseResult.getErrcode());
	    	if (0 != result) {
	            log.error("菜单创建失败, errcode: {}, errmsg: {}", baseResult.getErrcode(), baseResult.getErrmsg());
	    	}
	    }
	    return result;
	}
	
	/**
	 * 删除菜单
	 * 
	 * @param access_token 接口访问凭证
	 * @return 0表示成功, 其他值表示失败
	 */
	public static int deleteMenu(String access_token) {
		// 接口调用反馈结果
		int result = 1;
		// 删除菜单的URL
		String delete_menu_url = WXUrlDataProvider.getMenuDeleteRequestUrl(access_token);
		// 调用自定义菜单删除接口
		BaseResult baseResult = sendSSLGetRequest(delete_menu_url, BaseResult.class);
		if (baseResult != null) {
			result = Integer.valueOf(baseResult.getErrcode());
			if (0 != result) {
				log.error("菜单删除失败, errcode: {}, errmsg: {}", baseResult.getErrcode(), baseResult.getErrmsg());
			} else {
				log.info("删除自定义菜单成功！");
			}
		}
		return result;
	}
}