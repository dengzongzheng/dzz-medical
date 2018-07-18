package com.dzz.medical.controller.medical_manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 诚信自律
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月09 下午11:00
 */
@Controller
@RequestMapping("/honesty")
public class HonestyController {

    /**
     * 公共场所
     * @return 公共场所上报
     */
    @RequestMapping(value = "/publicPlace", method = RequestMethod.GET)
    public String publicPlace() {

        return "";
    }


    /**
     * 学校场所
     * @return 学校场所上报
     */
    @RequestMapping(value = "/schoolPlace", method = RequestMethod.GET)
    public String schoolPlace() {

        return "";
    }


    /**
     * 医疗场所
     * @return 医疗场所上报
     */
    @RequestMapping(value = "/medicalPlace", method = RequestMethod.GET)
    public String medicalPlace() {

        return "";
    }


    /**
     * 供水机构场所
     * @return 供水机构场所
     */
    @RequestMapping(value = "/waterSupplyPlace", method = RequestMethod.GET)
    public String waterSupplyPlace() {

        return "";
    }



    /**
     * 监督协管机构场所
     * @return 监督协管机构场所
     */
    @RequestMapping(value = "/controlManage", method = RequestMethod.GET)
    public String controlManage() {

        return "";
    }

}
