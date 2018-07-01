package com.dzz.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 核心管理后台启动类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:47
 */
@SpringBootApplication
public class MedicalApp {

    /**
     * 启动方法
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(MedicalApp.class, args);
    }
}
