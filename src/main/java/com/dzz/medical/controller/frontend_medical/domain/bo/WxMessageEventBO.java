package com.dzz.medical.controller.frontend_medical.domain.bo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 微信消息BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月25 上午7:55
 */
@XmlRootElement(name = "xml")
@Data
public class WxMessageEventBO implements Serializable{

    private static final long serialVersionUID = -8316559905311400292L;

    private String toUserName;

    private String fromUserName;

    private Integer createTime;

    private String msgType;

    private String event;

    private String eventKey;

    private String ticket;

    private String latitude;

    private String longitude;

    private String precision;

    private String msgId;

    private String content;

    private String picUrl;

    private String mediaId;

    private String format;

    private String recognition;

    private String thumbMediaId;

    private String location_X;

    private String location_Y;

    private String scale;

    private String label;

    private String title;

    private String description;

    private String url;

    private String status;

    private Integer totalCount;

    private Integer filterCount;

    private Integer sentCount;

    private Integer errorCount;

}
