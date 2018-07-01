package com.dzz.medical.common;

/**
 * 管理平台代码枚举
 *
 * @author dzz
 * @version 1.0.0
 * @since 2017年09月15 上午9:50
 */
public enum PlatformEnum {

    CENTRAL_ADMIN("central00001", "核心管理后台"),
    BUSINESS_ADMIN("business00001", "业务管理后台"),
    USER_ADMIN("user00001", "用户管理后台"),
    PORTAL_ADMIN("portal00001", "主站管理后台"),
    MANAGE_ADMIN("manage00001", "运营管理后台");

    private String code;

    private String value;

    PlatformEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据code取value
     * @param code code
     * @return 平台名称
     */
    public static String getTypeName(String code) {
        for (PlatformEnum c : PlatformEnum.values()) {
            if (c.code.equals(code)) {
                return c.value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
