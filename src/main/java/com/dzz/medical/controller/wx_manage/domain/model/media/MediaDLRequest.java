package com.dzz.medical.controller.wx_manage.domain.model.media;

import lombok.Data;

/**
 * 业务实体
 * @author dzz
 * @since  2018年06月30 下午8:26
 * @version  1.0.0
 */
@Data
public class MediaDLRequest {
	
	/** 默认允许的最大重试次数 */
	public static final int ALLOWED_MAX_RETRY = 3;
	
	/** 默认重试值 */
	public static final int DEFAULT_RETRY_VALUE = 0;
	
	/** 接口访问凭证 */
	private String token;
	
	/** 媒体文件ID */
	private String mediaId;
	
	/** 下载目录 */
	private String directory;
	
	/** 重试次数 */
	private int retry = DEFAULT_RETRY_VALUE;

}