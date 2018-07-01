package com.dzz.medical.controller.system.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "bs_admin_user")
public class BsAdminUser {
    /**
     * 主键ID
     */
    @Id
    @SequenceGenerator(name = "", sequenceName = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户账户
     */
    @Column(name = "account")
    private String account;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 联系人姓名
     */
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 联系人手机号
     */
    @Column(name = "contact_mobile")
    private String contactMobile;

    /**
     * 联系人邮箱
     */
    @Column(name = "contact_email")
    private String contactEmail;

    /**
     * 微信Id
     */
    @Column(name = "wx_id")
    private String wxId;

    /**
     * qq号
     */
    private String qq;

    /**
     * 状态信息:1有效数据、2暂存数据、0无效
     */
    private Integer status;

    /**
     * 最后更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新人用户code
     */
    private String updator;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建者用户code
     */
    private String creator;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户账户
     *
     * @return account - 用户账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 获取用户账户
     *
     * @return account - 用户账户
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取邮箱地址
     *
     * @return email - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系人姓名
     *
     * @return contact_name - 联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactName 联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取联系人手机号
     *
     * @return contact_mobile - 联系人手机号
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * 设置联系人手机号
     *
     * @param contactMobile 联系人手机号
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    /**
     * 获取联系人邮箱
     *
     * @return contact_email - 联系人邮箱
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 设置联系人邮箱
     *
     * @param contactEmail 联系人邮箱
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * 获取微信Id
     *
     * @return wx_id - 微信Id
     */
    public String getWxId() {
        return wxId;
    }

    /**
     * 设置微信Id
     *
     * @param wxId 微信Id
     */
    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    /**
     * 获取qq号
     *
     * @return qq - qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号
     *
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取状态信息:1有效数据、2暂存数据、0无效
     *
     * @return status - 状态信息:1有效数据、2暂存数据、0无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态信息:1有效数据、2暂存数据、0无效
     *
     * @param status 状态信息:1有效数据、2暂存数据、0无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后更新时间
     *
     * @return update_time - 最后更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param updateTime 最后更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人用户code
     *
     * @return updator - 更新人用户code
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * 设置更新人用户code
     *
     * @param updator 更新人用户code
     */
    public void setUpdator(String updator) {
        this.updator = updator;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建者用户code
     *
     * @return creator - 创建者用户code
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者用户code
     *
     * @param creator 创建者用户code
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }
}