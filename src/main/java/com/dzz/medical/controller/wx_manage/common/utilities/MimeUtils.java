package com.dzz.medical.controller.wx_manage.common.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.MimetypesFileTypeMap;

/**
 * 描述: 文件Mime工具类</br>
 * 
 * @author Shangxp
 * @version 1.0.0
 * @date 2016年6月16日 下午6:44:12
 * 
 * Copyright © 2016 BZN Corporation, All Rights Reserved.
 */
public class MimeUtils {

	/**
	 * JDK7自带了对ContentType的支持
	 * 
	 * @param fileName 文件名
	 * @return
	 */
	public static String getContentType(String fileName) {
		Path path = Paths.get(fileName);
		String contentType = null;
		try {
			contentType = Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentType;
	}

	/**
	 * JDK7以下版本, 建议使用activation
	 */
	private static MimetypesFileTypeMap MIME_TYPE_MAP = new MimetypesFileTypeMap();

	static {
		MIME_TYPE_MAP.addMimeTypes("image/jpeg jpg");
		MIME_TYPE_MAP.addMimeTypes("video/mp4 mp4");
		MIME_TYPE_MAP.addMimeTypes("audio/mpeg mp3");
		MIME_TYPE_MAP.addMimeTypes("audio/amr amr");
	}

	public static String getMimeContentType(File file) {
		return MIME_TYPE_MAP.getContentType(file);
	}

	public static String getMimeContentType(String fileName) {
		return MIME_TYPE_MAP.getContentType(fileName);
	}
}