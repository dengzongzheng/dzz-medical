package com.dzz.medical.controller.wx_manage.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dzz.medical.common.response.ResponseDzz;
import com.google.common.base.Strings;

/**
 * 微信接口服务
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月16 下午10:06
 */
public interface WxService {

    /**
     * 检查请求返回值
     * @param resultString 请求返回值
     * @return 检查结果
     */
    default ResponseDzz checkResult(String resultString) {

        if (Strings.isNullOrEmpty(resultString)) {
            return ResponseDzz.fail("请求结果为空");
        }

        JSONObject jsonObject = JSON.parseObject(resultString);
        Boolean isSuccess = "0".equals(jsonObject.getString("errcode")) || null == jsonObject.getString("errcode");
        if (isSuccess) {
            return ResponseDzz.ok(jsonObject);
        }else{
            return ResponseDzz.fail(jsonObject.getString("errmsg"));
        }
    }

    /**
     * 获取AccessToken
     * @param appId appId
     * @param secret 凭证密钥
     * @return access_token
     */
    ResponseDzz getAccessToken(String appId, String secret);

    /**
     * 删除菜单
     * @param accessToken token
     * @return 删除结果
     */
    ResponseDzz deleteMenu(String accessToken);

    /**
     * 创建菜单
     * @param menuJsonString 菜单Json
     * @return 创建结果
     */
    ResponseDzz createMenu(String menuJsonString);
}
