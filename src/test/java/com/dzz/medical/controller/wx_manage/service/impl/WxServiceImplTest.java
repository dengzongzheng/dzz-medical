package com.dzz.medical.controller.wx_manage.service.impl;

import com.dzz.medical.MedicalApp;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.wx_manage.service.WxService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月16 下午10:41
 */
@SpringBootTest(classes = MedicalApp.class)
@RunWith(SpringRunner.class)
@Slf4j
public class WxServiceImplTest {

    @Autowired
    private WxService wxService;

    @Autowired
    private WxConfig wxConfig;

    @Test
    public void getAccessToken() throws Exception {

        log.info("获取到的token:{}",wxService.getAccessToken(wxConfig.getAppId(),wxConfig.getAppSecret()));

    }

}