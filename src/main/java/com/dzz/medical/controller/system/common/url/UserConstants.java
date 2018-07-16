package com.dzz.medical.controller.system.common.url;/** * @author dzz * @since 2017年06月19 下午10:35 * @version 1.0.0 */public class UserConstants {    /**     * 管理系统平台代码     */    public static final String PLATFORM_CODE = "manage00001";    /**超级管理员角色代码*/    public static final String SUPPER_ADMIN_ROLE = "admin";    /**超级管理员角色类型*/    public static final String SUPPER_ADMIN_ROLE_TYPE = "1";    /**     * 用户密码加密盐值     */    private static final String[] SALT_DATA_SOURCE = {        "$1$a1Bef7829d235ebc", "$1$bade123512d8a3f5", "$1$5d8a9e1b8d8a3ce1", "$1$e41ad6e6fb731d9e",        "$1$b91ad4ef8bd8fead", "$1$3ade5fedb64a9538", "$1$987ade91bde913ad", "$1$98de12bf83adf931" };    /**     * 获取盐值值     * @param userId 用户ID     * @return 密码盐值     */    public static String getSaltValue(String userId) {        return SALT_DATA_SOURCE[Math.abs(userId.hashCode() % SALT_DATA_SOURCE.length)];    }}