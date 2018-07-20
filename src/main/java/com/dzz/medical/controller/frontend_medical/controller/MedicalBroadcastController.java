package com.dzz.medical.controller.frontend_medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 卫监播报控制层
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月09 下午10:58
 */
@Controller
@RequestMapping("/broadcast")
public class MedicalBroadcastController {

    /**
     * 通知公告
     * @return 通知公告页面
     */
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String notice() {

        return "/medical_manage/medical_broadcast/notice";
    }


    /**
     * 工作动态
     * @return 工作动态页面
     */
    @RequestMapping(value = "/workNews", method = RequestMethod.GET)
    public String workNews() {

        return "/medical_manage/medical_broadcast/work_news";
    }


    /**
     * 卫生知识
     * @return 卫生知识页面
     */
    @RequestMapping(value = "/medicalInformation", method = RequestMethod.GET)
    public String medicalInformation() {

        return "/medical_manage/medical_broadcast/medical_information";
    }



    /**
     * 关于我们
     * @return 关于我们页面
     */
    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String aboutUs() {

        return "/medical_manage/medical_broadcast/about_us";
    }


}
