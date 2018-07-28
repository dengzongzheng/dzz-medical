package com.dzz.medical.controller.frontend_medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 医药管理控制层
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:15
 */
@Controller
@RequestMapping("/manage")
public class MedicalManageController {

    /**
     * 管理
     * @return 页面
     */
    @RequestMapping(value = "/medicalManage", method = RequestMethod.GET)
    public String medicalManage() {

        return "/frontend_medical/manage";
    }
}
