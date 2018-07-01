package com.dzz.medical.controller.system.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "bs_admin_platform")
public class BsAdminPlatform {
    /**
     * 主键ID
     */
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 平台Id
     */
    @Column(name = "platform_id")
    private String platformId;

    /**
     * 平台名称
     */
    private String name;

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
     * 获取平台Id
     *
     * @return platform_id - 平台Id
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * 设置平台Id
     *
     * @param platformId 平台Id
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    /**
     * 获取平台名称
     *
     * @return name - 平台名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置平台名称
     *
     * @param name 平台名称
     */
    public void setName(String name) {
        this.name = name;
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