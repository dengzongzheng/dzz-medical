package com.dzz.medical.controller.wx_manage.service;

/**
 * 微信接口服务
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月16 下午10:06
 */
public interface WxService {

    /**
     * 获取AccessToken
     * @param appId appId
     * @param secret 凭证密钥
     * @return access_token
     */
    String getAccessToken(String appId, String secret);
}
