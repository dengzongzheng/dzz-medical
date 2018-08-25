package com.dzz.medical.controller.frontend_medical.service.impl;

import com.dzz.medical.config.wx.MessageConfig;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.frontend_medical.domain.bo.WxMessageEventBO;
import com.dzz.medical.controller.frontend_medical.service.MessageEventService;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息应答处理接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午11:10
 */
@Service
@Slf4j
public class MessageEventServiceImpl implements MessageEventService {

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private MessageConfig messageConfig;

    @Override
    public String messageEventHandler(HttpServletRequest request) {

        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        try {
            WxMessageEventBO wxMessageEventBO = (WxMessageEventBO) xStream.fromXML(request.getInputStream());
            log.info("消息数据为：{}",wxMessageEventBO.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }


    @Override
    public Boolean checkSignature(List<String> signDataArray, String signature) {

        Collections.sort(signDataArray);
        StringBuilder decodeString = new StringBuilder(signDataArray.get(0)).append(signDataArray.get(1))
                .append(signDataArray.get(2));
        String codeSha1 = DigestUtils.sha1Hex(decodeString.toString());
        log.info("signature:{},codeSha1:{}", signature, codeSha1);
        return signature.equals(codeSha1);
    }
}
