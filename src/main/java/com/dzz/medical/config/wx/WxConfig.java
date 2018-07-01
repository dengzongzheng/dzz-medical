package com.dzz.medical.config.wx;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:19
 */
@Data
@Configuration
public class WxConfig {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

    @Value("${wx.serverPath}")
    private String serverPath;
}
