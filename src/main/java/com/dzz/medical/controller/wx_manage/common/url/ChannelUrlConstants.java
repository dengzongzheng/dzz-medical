package com.dzz.medical.controller.wx_manage.common.url;

/**
 * 运营管理后台Url配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年03月22 下午6:12
 */
public interface ChannelUrlConstants {

    /**
     * 销售渠道模板根目录
     */
    String CHANNEL_BASE = "/channel";

    /**************************页面跳转************************************************/

    /**
     * 渠道管理页
     */
    String CHANNEL_MANAGE = CHANNEL_BASE + "/channel_manage";


    /**
     * 渠道查询
     */
    String CHANNEL_QUERY = CHANNEL_BASE + "/channel_query";



    /**
     * 去编辑渠道
     */
    String TO_CHANNEL_EDIT = CHANNEL_BASE + "/to_channel_edit";



    /**
     * 编辑渠道
     */
    String CHANNEL_EDIT = CHANNEL_BASE + "/channel_edit";



    /**
     * 去新增渠道
     */
    String TO_CHANNEL_ADD = CHANNEL_BASE + "/to_channel_add";



    /**
     * 新增渠道
     */
    String CHANNEL_ADD = CHANNEL_BASE + "/channel_add";


    /**
     * 去渠道详情
     */
    String TO_CHANNEL_DETAIL = CHANNEL_BASE + "/to_channel_detail";



    /**
     * 渠道详情
     */
    String CHANNEL_DETAIL = CHANNEL_BASE + "/channel_detail";


    /**
     * 渠道审核管理
     */
    String CHANNEL_VERIFY_MANAGE = CHANNEL_BASE + "/channel_verify_manage";


    /**
     * 渠道审核查询
     */
    String CHANNEL_VERIFY_QUERY = CHANNEL_BASE + "/channel_verify_query";



    /**
     * 渠道审核
     */
    String CHANNEL_VERIFY = CHANNEL_BASE + "/channel_verify";

    /**
     * 渠道协议管理页面
     */
    String TO_PROTOCOL_MANAGE =  CHANNEL_BASE + "/to_protocol_manage";

    /**
     * 渠道协议查询
     */
    String TO_PROTOCOL_QUERY =  CHANNEL_BASE + "/protocol_query";

    /**
     * 下载协议
     */
    String PROTOCOL_DOWNLOAD =  CHANNEL_BASE + "/protocol_download";


    /**
     * 上传协议
     */
    String PROTOCOL_UPLOAD =  CHANNEL_BASE + "/protocol_upload";

    /**
     * 查询当前有效的渠道信息
     */
    String LIST_COOPERATION_CHANNEL= CHANNEL_BASE +"/list_cooperation_channel";
}
