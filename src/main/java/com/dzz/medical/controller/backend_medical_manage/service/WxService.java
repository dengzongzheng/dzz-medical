package com.dzz.medical.controller.backend_medical_manage.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.controller.backend_medical_manage.common.constant.WxConstant;
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
        Boolean isSuccess =
                WxConstant.REQUEST_SUCCESS_CODE.equals(jsonObject.getString(WxConstant.REQUEST_ERROR_MESSAGE_CODE_KEY))
                        || null == jsonObject.getString(WxConstant.REQUEST_ERROR_MESSAGE_CODE_KEY);
        if (isSuccess) {
            return ResponseDzz.ok(jsonObject);
        }else{
            return ResponseDzz.fail(jsonObject.getString(WxConstant.REQUEST_ERROR_MESSAGE_KEY));
        }
    }

    /**
     * 构建菜单对象
     * @param name 菜单名称
     * @param type 类型
     * @param url 地址
     * @param key key
     * @return 结果
     */
    default JSONObject createMenuJSONObject(String name, String type, String url,String key) {

        JSONObject menuJSONObject = new JSONObject();
        menuJSONObject.put("name", name);
        menuJSONObject.put("type", type);
        if (WxConstant.BUTTON_TYPE_VIEW.equals(type)) {
            menuJSONObject.put("url", url);
        }
        if (WxConstant.BUTTON_TYPE_CLICK.equals(type)) {
            menuJSONObject.put("key", key);
        }
        return menuJSONObject;
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
     * @return 删除结果
     */
    ResponseDzz deleteMenu();

    /**
     * 创建菜单
     * @param menuJsonString 菜单Json
     * @return 创建结果
     */
    ResponseDzz createMenu(String menuJsonString);
}
