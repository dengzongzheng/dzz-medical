package com.dzz.medical.controller.wx_manage.service.impl;

import com.dzz.medical.common.http.HttpService;
import com.dzz.medical.common.response.ResponseDzz;
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
    public ResponseDzz getAccessToken(String appId, String secret) {

        StringBuilder urlBuilder = new StringBuilder(wxConfig.getAccessTokenUrl());
        urlBuilder.append("grant_type=client_credential").append("&appid=").append(appId).append("&secret=")
                .append(secret);
        String result = HttpService.sendRequest(urlBuilder.toString(), "get", "");
        return checkResult(result);
    }

    @Override
    public ResponseDzz deleteMenu(String accessToken) {

        StringBuilder urlBuilder = new StringBuilder(wxConfig.getDeleteMenuUrl());
        urlBuilder.append("access_token=").append("");
        String result = HttpService.sendRequest(urlBuilder.toString(), "get", "");
        return checkResult(result);
    }

    @Override
    public ResponseDzz createMenu(String menuJsonString) {

        return null;
    }
}
