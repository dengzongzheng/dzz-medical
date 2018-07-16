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
}
