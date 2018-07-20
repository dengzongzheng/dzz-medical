package com.dzz.medical.controller.backend_medical_manage.common.utilities.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述: HTTP请求服务类</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2015.05.11
 */
public class HTTPService {
	
	private static final Logger log = LoggerFactory.getLogger(HTTPService.class);
	
	/**
	 * 发起HTTP请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式(GET, POST)
	 * @param outputStr 提交的数据
	 * @return
	 */
	public static String sendRequest(String requestUrl, String requestMethod, String outputStr) {
		// 方法执行返回值
		StringBuffer buffer = new StringBuffer();
		
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			
			// 设置是否向httpUrlConnection输出, 如果是POST请求, 参数要放在http正文内, 因此需要设为true, 默认情况下是false
			httpUrlConn.setDoOutput(true);
			// 设置是否从httpUrlConnection读入, 默认情况下是true
			httpUrlConn.setDoInput(true);
			// POST请求不能使用缓存
			httpUrlConn.setUseCaches(false);
			// 设置连接主机超时, 30秒
			httpUrlConn.setConnectTimeout(30000);
			// 设置从主机读取数据超时, 30秒
			httpUrlConn.setReadTimeout(30000);
			
			// 设置传送的内容类型是可序列化的Java对象
			// 如果不设此项, 在传送序列化对象时, 当WEB服务默认的不是这种类型时可能抛java.io.EOFException
			httpUrlConn.setRequestProperty("Content-type", "application/x-java-serialized-object");
			
			// 设置请求方式, 默认是GET
			httpUrlConn.setRequestMethod(requestMethod);

			// 连接, 上面对httpUrlConn的所有配置必须要在connect之前完成
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				// 此处getOutputStream会隐含的进行connect(即: 如同调用上面的connect()方法, 所以在开发中不调用上述的connect()也可以)
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式, 防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			
			bufferedReader.close();
			inputStreamReader.close();
			
			// 释放资源
			inputStream.close();
			inputStream = null;
			
			httpUrlConn.disconnect();
			
			return buffer.toString();
		} catch (ConnectException ce) {
			log.error("Remote server connection timed out.");
		} catch (Exception e) {
			log.error("Http request error: {}", e);
		}
		return null;
	}
}