package com.dzz.medical.controller.backend_medical_manage.service;

/**
 * 微信相关管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:17
 */

public interface WxManageService {

    /**
     * 消息事件处理
     * @param key 消息关键字
     * @param openId openId
     * @return 处理结果
     */
    String messageEventHandler(String key,String openId);
}
