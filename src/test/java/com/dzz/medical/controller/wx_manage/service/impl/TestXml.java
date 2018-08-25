package com.dzz.medical.controller.wx_manage.service.impl;

import com.dzz.medical.controller.frontend_medical.domain.bo.WxMessageEventBO;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月25 上午9:18
 */
@Slf4j
public class TestXml {


    public static void main(String[] args) {

        String xml = "<xml><ToUserName><![CDATA[gh_1867807895d9]]></ToUserName>\n"
                + "<FromUserName><![CDATA[o4k7v0ti0tS2MOdmWMjYjLpi0It8]]></FromUserName>\n"
                + "<CreateTime>1535159718</CreateTime>\n"
                + "<MsgType><![CDATA[event]]></MsgType>\n"
                + "<Event><![CDATA[CLICK]]></Event>\n"
                + "<EventKey><![CDATA[V1001_TODAY_MUSIC]]></EventKey>\n"
                + "</xml>";

        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        xStream.processAnnotations(WxMessageEventBO.class);
        WxMessageEventBO wxMessageEventBO = (WxMessageEventBO) xStream.fromXML(xml);

        log.info(wxMessageEventBO.toString());
    }

}
