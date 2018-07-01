package com.dzz.medical.common;



/**
 * 账号密码工具类
 *
 * @author shengyf
 * @version 2.0.0
 * @since 2017/9/29 20:17
 */
public final class UserAccountUtil {

    private static final int SALT_SIZE = 8;
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_ITERATIONS = 1024;

    /**
     * 用户密码加密盐值
     */
    private static final String[] SALT_DATA_SOURCE = {
            "$1$a1Bef7829d235ebc", "$1$bade123512d8a3f5", "$1$5d8a9e1b8d8a3ce1", "$1$e41ad6e6fb731d9e",
            "$1$b91ad4ef8bd8fead", "$1$3ade5fedb64a9538", "$1$987ade91bde913ad", "$1$98de12bf83adf931"};

    /**
     * 获取盐值值
     *
     * @param userName 用户账号
     * @return 密码盐值
     */
    public static String getSaltValue(String userName) {
        return SALT_DATA_SOURCE[Math.abs(userName.hashCode() % SALT_DATA_SOURCE.length)];
    }

    /**
     * 获取随机盐值
     *
     * @return
     */
    public static String generateSalt() {
        byte[] salt = DigestUtils.generateSalt(SALT_SIZE);
        return EncodeUtils.encodeHex(salt);
    }

    /**
     * 密码加密
     *
     * @param plainPassword 明文密码
     * @param salt          盐值
     * @return
     */
    public static String hashPassword(String plainPassword, String salt) {
        byte[] hashPassword = DigestUtils.sha1(plainPassword.getBytes(), EncodeUtils.decodeHex(salt), HASH_ITERATIONS);
        return EncodeUtils.encodeHex(hashPassword);
    }

    /**
     * 验证密码是否正确
     *
     * @param password 明文密码
     * @param salt     盐值
     * @param security 密文
     * @return true：密码正确；false：密码错误
     */
    public static Boolean checkPassword(String password, String salt, String security) {
        return security.equals(UserAccountUtil.hashPassword(password, salt));
    }
}
