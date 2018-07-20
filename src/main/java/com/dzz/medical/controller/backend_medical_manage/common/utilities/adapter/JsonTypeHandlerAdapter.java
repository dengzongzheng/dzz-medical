package com.dzz.medical.controller.backend_medical_manage.common.utilities.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 描述: JSON数据处理</br>
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2017.10.13 下午13:56
 *
 * Copyright © 2017 BZN Corporation, All Rights Reserved.
 */
public class JsonTypeHandlerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(JsonTypeHandlerAdapter.class);

    private ObjectMapper objectMapper;

    private final static JsonTypeHandlerAdapter ADAPTER = new JsonTypeHandlerAdapter();

    /**
     * 私有的默认构造方法
     */
    private JsonTypeHandlerAdapter() {
        objectMapper = new ObjectMapper();
        // 设置可用单引号
        objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置字段可以不用双引号包括
        objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 设置时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 禁用未知属性打断反序列化功能
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 静态工厂方法
     */
    public static JsonTypeHandlerAdapter getInstance() {
        return ADAPTER;
    }

    /**
     * 从请求流中解析JSON
     *
     * @param request 请求对象
     * @param clazz   要转换的JavaBean
     * @return JavaBean实体对象
     */
    public <T> T parseJson(HttpServletRequest request, Class<T> clazz) throws IOException {
        String json = parseJson(request);
        return json2Object(json, clazz);
    }

    /**
     * 从请求流中解析JSON
     *
     * @param request 请求对象
     * @return JSON字符串
     */
    private String parseJson(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }

    /**
     * 从一个JSON对象字符格式中得到一个Java对象
     *
     * @param json  JSON字符串
     * @param clazz 要转换的JavaBean
     * @return JavaBean实体对象
     */
    public <T> T json2Object(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error("JSON字符串转换Java对象发生异常", e);
        }
        return null;
    }

    /**
     * 将Java对象转换成Json字符串
     *
     * @param obj JavaBean实体对象
     * @return Json字符串
     */
    public String object2Json(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Java对象转换JSON字符串发生异常", e);
        }
        return null;
    }

    /**
     * 将Java对象转换成Json字符串, 忽略空值
     *
     * @param obj JavaBean实体对象
     * @return Json字符串
     */
    public String object2JsonIgnoreNull(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        // 设置可用单引号
        mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置字段可以不用双引号包括
        mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 忽略空值
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Java对象转换JSON字符串发生异常", e);
        }
        return null;
    }
}