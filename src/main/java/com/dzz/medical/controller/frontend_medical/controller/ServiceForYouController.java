package com.dzz.medical.controller.frontend_medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 为您服务控制层
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月09 下午10:56
 */
@Controller
@RequestMapping("/forService")
public class ServiceForYouController {


    /**
     * 法律法规
     * @return 法律法规介绍
     */
    @RequestMapping(value = "/legal", method = RequestMethod.GET)
    public String legal() {

        return "/medical_manage/for_service/legal";
    }


}
