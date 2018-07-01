package com.dzz.medical.controller.wx_manage.service;

import com.dzz.medical.MedicalApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午9:24
 */
@SpringBootTest(classes = MedicalApp.class)
@RunWith(SpringRunner.class)
public class WxManageServiceTest {

    @Autowired
    private WxManageService wxManageService;

    @Test
    public void createMenu() throws Exception {

        wxManageService.createMenu();
    }

}