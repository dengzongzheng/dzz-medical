package com.dzz.medical.controller.wx_manage.service.impl;

import com.dzz.medical.common.http.HttpService;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.wx_manage.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信接口相关实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月16 下午10:08
 */
@Service
public class WxServiceImpl implements WxService {

    @Autowired
    private WxConfig wxConfig;

    @Override
    public String getAccessToken(String appId, String secret) {

        String requestUrl = wxConfig.getAccessTokenUrl();
        StringBuilder urlBuilder = new StringBuilder(requestUrl);
        urlBuilder.append("grant_type=client_credential").append("&appid=").append(appId).append("&secret=")
                .append(secret);
        return HttpService.sendRequest(urlBuilder.toString(), "get", "");
    }
}
