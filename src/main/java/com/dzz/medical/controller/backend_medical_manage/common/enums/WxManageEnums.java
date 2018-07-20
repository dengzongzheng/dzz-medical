package com.dzz.medical.controller.backend_medical_manage.common.enums;

import java.util.Objects;


/**
 * 微信相关枚举类
 * @author dzz
 * @version 1.0.0
 * @since 2018年03月22 下午6:12
 */
public interface WxManageEnums {

    /** 消息 */
    enum MessageEvent {

        COMPLAINT("V10001_I_WANT_COMPLAINT", "我要投诉"),
        GUIDE("V10001_WORK_GUIDE","办事指南")
        ;

        /** 商品编号 */
        private String code;

        /** 商品名称 */
        private String name;

        MessageEvent(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(String code) {
            for (MessageEvent info : MessageEvent.values()) {
                if (Objects.equals(code, info.getCode())) {
                    return info.getName();
                }
            }
            return null;
        }
    }

}
