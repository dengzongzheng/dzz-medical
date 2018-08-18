package com.dzz.medical.controller.backend_medical_manage.service.impl;

import static com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MessageEvent.COMPLAINT;

import com.dzz.medical.config.wx.MessageConfig;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MessageTypeEnums;
import com.dzz.medical.controller.backend_medical_manage.service.WxManageService;
import com.dzz.medical.controller.frontend_medical.domain.message.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信管理接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月17 上午7:23
 */
@Service
public class WxManageServiceImpl implements WxManageService {

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private MessageConfig messageConfig;

    @Override
    public String messageEventHandler(String key) {

        if (COMPLAINT.getCode().equals(key)) {

            TextMessage textMessage = new TextMessage();
            textMessage.setFromUserName(wxConfig.getAppId());
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setMsgId(System.currentTimeMillis());
            textMessage.setMsgType(MessageTypeEnums.TEXT.getName());
            textMessage.setContent(messageConfig.getComplaintMessage());
            textMessage.setToUserName("dzz_hi");

            XStream xStream = new XStream();
            xStream.autodetectAnnotations(true);
            return xStream.toXML(textMessage);
        }

        return "success";
    }
}
