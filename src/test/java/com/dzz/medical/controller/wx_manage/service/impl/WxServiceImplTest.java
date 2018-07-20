package com.dzz.medical.controller.wx_manage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dzz.medical.MedicalApp;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MessageEvent;
import com.dzz.medical.controller.backend_medical_manage.service.WxService;
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

        log.info("获取到的token:{}",wxService.getAccessToken(wxConfig.getAppId(),wxConfig.getAppSecret()).toString());

    }

    @Test
    public void menuDelete() {

        log.info("菜单删除结果:{}", wxService.deleteMenu().toString());

    }


    @Test
    public void menuCreate() {


        ResponseDzz responseDzz = wxService.deleteMenu();
        if (responseDzz.checkFail()) {
            log.error("删除菜单失败，不能进行添加菜单。失败原因:{}", responseDzz.getMessage());
            return;
        }
        JSONObject menuJSON = new JSONObject();
        JSONObject firstMenuJSON = wxService.createMenuJSONObject("为您服务","","","");
        JSONArray firstMenuJSONSub = new JSONArray();
        JSONObject firstSub1 = wxService.createMenuJSONObject("我要投诉","click","", MessageEvent.COMPLAINT.getCode());
        JSONObject firstSub2 = wxService.createMenuJSONObject("办事指南","click","",MessageEvent.GUIDE.getCode());
        JSONObject firstSub3 = wxService.createMenuJSONObject("法律法规","view",wxConfig.getServerPath() + "/forService/legal","");
        firstMenuJSONSub.add(firstSub1);
        firstMenuJSONSub.add(firstSub2);
        firstMenuJSONSub.add(firstSub3);
        firstMenuJSON.put("sub_button", firstMenuJSONSub);

        JSONObject secondMenuJSON = wxService.createMenuJSONObject("卫监播报","","","");
        JSONArray secondMenuJSONSub = new JSONArray();
        JSONObject secondSub1 = wxService.createMenuJSONObject("通知公告","view",wxConfig.getServerPath() + "/broadcast/notice","");
        JSONObject secondSub2 = wxService.createMenuJSONObject("工作动态","view",wxConfig.getServerPath() + "/broadcast/workNews","");
        JSONObject secondSub3 = wxService.createMenuJSONObject("卫生知识","view",wxConfig.getServerPath() + "/broadcast/medicalInformation","");
        JSONObject secondSub4 = wxService.createMenuJSONObject("关于我们","view",wxConfig.getServerPath() + "/broadcast/aboutUs","");
        secondMenuJSONSub.add(secondSub1);
        secondMenuJSONSub.add(secondSub2);
        secondMenuJSONSub.add(secondSub3);
        secondMenuJSONSub.add(secondSub4);
        secondMenuJSON.put("sub_button", secondMenuJSONSub);

        JSONObject thirdMenuJSON = wxService.createMenuJSONObject("诚信自律","","","");
        JSONArray thirdMenuJSONSub = new JSONArray();
        JSONObject thirdSub1 = wxService.createMenuJSONObject("公共场所","view",wxConfig.getServerPath() + "/honesty/publicPlace","");
        JSONObject thirdSub2 = wxService.createMenuJSONObject("学校卫生","view",wxConfig.getServerPath() + "/honesty/schoolPlace","");
        JSONObject thirdSub3 = wxService.createMenuJSONObject("医疗机构","view",wxConfig.getServerPath() + "/honesty/medicalPlace","");
        JSONObject thirdSub4 = wxService.createMenuJSONObject("供水单位","view",wxConfig.getServerPath() + "/honesty/waterSupplyPlace","");
        JSONObject thirdSub5 = wxService.createMenuJSONObject("监督管理","view",wxConfig.getServerPath() + "/honesty/controlManage","");
        thirdMenuJSONSub.add(thirdSub1);
        thirdMenuJSONSub.add(thirdSub2);
        thirdMenuJSONSub.add(thirdSub3);
        thirdMenuJSONSub.add(thirdSub4);
        thirdMenuJSONSub.add(thirdSub5);
        thirdMenuJSON.put("sub_button", thirdMenuJSONSub);

        JSONArray buttonArray = new JSONArray();
        buttonArray.add(firstMenuJSON);
        buttonArray.add(secondMenuJSON);
        buttonArray.add(thirdMenuJSON);

        menuJSON.put("button", buttonArray);

        log.info("菜单新建结果:{}", wxService.createMenu(menuJSON.toJSONString()).toString());
    }

}