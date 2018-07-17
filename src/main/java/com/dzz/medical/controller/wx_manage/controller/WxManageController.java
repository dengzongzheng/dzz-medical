package com.dzz.medical.controller.wx_manage.controller;

import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.wx_manage.service.WxManageService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信管理控制层
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:15
 */
@Controller
@RequestMapping("/wx")
@Slf4j
public class WxManageController {

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private WxManageService wxManageService;

    /**
     * 接收消息,用于处理服务器地址验证
     *
     * @return 消息处理
     */
    @RequestMapping(value = "/messageEvent", method = {RequestMethod.GET})
    @ResponseBody
    public String messageEvent(HttpServletRequest request) {

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echoString = request.getParameter("echostr");

        List<String> tempArray = new ArrayList<>(3);
        tempArray.add(timestamp);
        tempArray.add(nonce);
        tempArray.add(wxConfig.getToken());

        Collections.sort(tempArray);
        StringBuilder decodeString = new StringBuilder(tempArray.get(0)).append(tempArray.get(1))
                .append(tempArray.get(2));
        String codeSha1 = DigestUtils.sha1Hex(decodeString.toString());
        log.info("signature:{},codeSha1:{}", signature, codeSha1);
        if (signature.equals(codeSha1)) {
            return echoString;
        }else{
            return "false";
        }
    }

    /**
     * 接收消息,用于处理消息事件
     *
     * @return 消息处理
     */
    @RequestMapping(value = "/messageEvent", method = {RequestMethod.POST})
    @ResponseBody
    public String messageEvent(HttpServletRequest request,HttpServletResponse response) {

        String key = request.getParameter("key");
        log.info("接收到的消息关键字为:{}", key);
        wxManageService.messageEventHandler(key);
        return "success";
    }
}
