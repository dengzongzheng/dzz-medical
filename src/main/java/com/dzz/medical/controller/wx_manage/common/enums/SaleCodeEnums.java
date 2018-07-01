package com.dzz.medical.controller.wx_manage.common.enums;

import java.util.Objects;


/**
 * 业管系统相关枚举类
 * @author dzz
 * @version 1.0.0
 * @since 2018年03月22 下午6:12
 */
public interface SaleCodeEnums {

    /** 商品信息 */
    enum ProductInfo {

        BABYINSURANCE("P00001471", "中意财意外险——宝贝保");
        /** 商品编号 */
        private String code;

        /** 商品名称 */
        private String name;

        ProductInfo(String code, String name) {
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
            for (ProductInfo info : ProductInfo.values()) {
                if (Objects.equals(code, info.getCode())) {
                    return info.getName();
                }
            }
            return null;
        }
    }

    /** 渠道信息 */
    enum ChannelInfo {

        SHJY("010300001032", "北京上和教育咨询有限公司"),
        BZN("010300000010", "保准牛官网");
        /** 通道枚举值 */
        private String code;

        /** 通道名称 */
        private String name;

        ChannelInfo(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getTypeByCode(String code) {
            for (ChannelInfo channelInfo : ChannelInfo.values()) {
                if (Objects.equals(code, channelInfo.getCode())) {
                    return channelInfo.getName();
                }
            }
            return null;
        }
    }

    /** 投保人类型 */
    enum HolderType {
        PERSON("1", "个人"),
        COMPANY("2", "企业"),
        OTHER("3","其它");
        /** 投保人举值 */
        private String code;

        /** 投保人名称 */
        private String name;

        HolderType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getTypeByCode(String code) {
            for (HolderType holderType : HolderType.values()) {
                if (Objects.equals(code, holderType.getCode())) {
                    return holderType.getName();
                }
            }
            return null;
        }

    }

    /** 企业性质 */
    enum EntType {
        STATEOENED(1, "私企"),
        COMPANY(2, "国企");
        /** 投保人举值 */
        private Integer code;

        /** 投保人名称 */
        private String name;

        EntType(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getTypeByCode(Integer code) {
            for (EntType entType : EntType.values()) {
                if (Objects.equals(code, entType.getCode())) {
                    return entType.getName();
                }
            }
            return null;
        }

    }

    /** 公司类型 */
    enum SubjectCompanyRelationShip {
        SAME(1, "相同"),
        DIFFICENT(2, "不相同"),
        DISPLAYNONE(3, "不展示");
        /** 投保人举值 */
        private Integer code;

        /** 投保人名称 */
        private String name;

        SubjectCompanyRelationShip(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getTypeByCode(Integer code) {
            for (SubjectCompanyRelationShip subjectCompanyRelationShip : SubjectCompanyRelationShip.values()) {
                if (Objects.equals(code, subjectCompanyRelationShip.getCode())) {
                    return subjectCompanyRelationShip.getName();
                }
            }
            return null;
        }

    }
}
