package com.dzz.medical.controller.wx_manage.api;


import com.dzz.medical.controller.wx_manage.common.constant.ConstantDataProvider;
import com.dzz.medical.controller.wx_manage.common.utilities.adapter.JsonTypeHandlerAdapter;
import com.dzz.medical.controller.wx_manage.common.utilities.http.HTTPService;
import com.dzz.medical.controller.wx_manage.common.utilities.http.SSLService;

public abstract class BaseAPI {
	
	/**
	 * 发送HTTPS/GET请求
	 * 
	 * @param url 接口请求地址
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendSSLGetRequest(String url, Class<T> clazz) {
		return sendSSLRequest(url, ConstantDataProvider.GET, null, clazz);
	}
	
	/**
	 * 发送HTTPS/GET请求
	 * 
	 * @param url 接口请求地址
	 * @param data 请求数据
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendSSLGetRequest(String url, String data, Class<T> clazz) {
		return sendSSLRequest(url, ConstantDataProvider.GET, data, clazz);
	}
	
	/**
	 * 发送HTTPS/POST请求
	 * 
	 * @param url 接口请求地址
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendSSLPostRequest(String url, Class<T> clazz) {
		return sendSSLRequest(url, ConstantDataProvider.POST, null, clazz);
	}
	
	/**
	 * 发送HTTPS/POST请求
	 * 
	 * @param url 接口请求地址
	 * @param data 请求数据
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendSSLPostRequest(String url, String data, Class<T> clazz) {
		return sendSSLRequest(url, ConstantDataProvider.POST, data, clazz);
	}
	
	/**
	 * 微信HTTPS接口请求统一方法
	 */
	private static <T> T sendSSLRequest(String url, String method, String data, Class<T> clazz) {
		// 发送请求
		String json = SSLService.sendRequest(url, method, data);
		// 处理返回数据
		return JsonTypeHandlerAdapter.getInstance().json2Object(json, clazz);
	}
	
	/**
	 * 发送HTTP/GET请求
	 * 
	 * @param url 接口请求地址
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendGetRequest(String url, Class<T> clazz) {
		return sendRequest(url, ConstantDataProvider.GET, null, clazz);
	}
	
	/**
	 * 发送HTTP/GET请求
	 * 
	 * @param url 接口请求地址
	 * @param data 请求数据
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendGetRequest(String url, String data, Class<T> clazz) {
		return sendRequest(url, ConstantDataProvider.GET, data, clazz);
	}
	
	/**
	 * 发送HTTP/POST请求
	 * 
	 * @param url 接口请求地址
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendPostRequest(String url, Class<T> clazz) {
		return sendRequest(url, ConstantDataProvider.POST, null, clazz);
	}
	
	/**
	 * 发送HTTP/POST请求
	 * 
	 * @param url 接口请求地址
	 * @param data 请求数据
	 * @param clazz
	 * @return
	 */
	protected static <T> T sendPostRequest(String url, String data, Class<T> clazz) {
		return sendRequest(url, ConstantDataProvider.POST, data, clazz);
	}
	
	/**
	 * 微信HTTP接口请求统一方法
	 */
	private static <T> T sendRequest(String url, String method, String data, Class<T> clazz) {
		// 发送请求
		String json = HTTPService.sendRequest(url, method, data);
		// 处理返回数据
		return JsonTypeHandlerAdapter.getInstance().json2Object(json, clazz);
	}
}