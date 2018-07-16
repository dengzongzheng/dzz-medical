package com.dzz.medical.controller.medical_manage.controller;

import com.dzz.medical.common.response.ResponseDzz;
import org.springframework.http.ResponseEntity;
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
     * 我要投诉
     * @return 投诉信息
     */
    @RequestMapping(value = "/complaint", method = RequestMethod.POST)
    public ResponseEntity<?> complaint() {

        return ResponseEntity.ok(ResponseDzz.ok());
    }


    /**
     * 办事指南
     * @return 指南信息
     */
    @RequestMapping(value = "/guide", method = RequestMethod.POST)
    public ResponseEntity<?> guide() {

        return ResponseEntity.ok(ResponseDzz.ok());
    }

    /**
     * 法律法规
     * @return 法律法规介绍
     */
    @RequestMapping(value = "/legal", method = RequestMethod.GET)
    public String legal() {

        return "";
    }
}
