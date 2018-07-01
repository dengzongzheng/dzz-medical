package com.dzz.medical.controller.system.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "bs_admin_permit")
public class BsAdminPermit {
    /**
     * 主键ID
     */
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 权限Id
     */
    @Column(name = "permit_id")
    private String permitId;

    /**
     * 权限名称
     */
    private String text;

    /**
     * 平台Id
     */
    @Column(name = "platform_id")
    private String platformId;

    /**
     * 菜单数据存放

     */
    private String data;

    /**
     * 权限类型:1菜单、2功能按钮
     */
    @Column(name = "permit_type")
    private Integer permitType;

    /**
     * 父级权限Id,顶级菜单权限父级Id为0、功能级权限父级Id为其上级菜单权限Id
     */
    @Column(name = "parent_permit_id")
    private String parentPermitId;

    /**
     * 菜单icon
     */
    private String icon;

    /**
     * 菜单权限是否为最后一级 0:否、1是
     */
    private Integer extremity;

    /**
     * 排序字段
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 权限地址
     */
    private String url;

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
     * 获取权限Id
     *
     * @return permit_id - 权限Id
     */
    public String getPermitId() {
        return permitId;
    }

    /**
     * 设置权限Id
     *
     * @param permitId 权限Id
     */
    public void setPermitId(String permitId) {
        this.permitId = permitId;
    }

    /**
     * 获取权限名称
     *
     * @return text - 权限名称
     */
    public String getText() {
        return text;
    }

    /**
     * 设置权限名称
     *
     * @param text 权限名称
     */
    public void setText(String text) {
        this.text = text;
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
     * 获取菜单数据存放

     *
     * @return data - 菜单数据存放

     */
    public String getData() {
        return data;
    }

    /**
     * 设置菜单数据存放

     *
     * @param data 菜单数据存放

     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 获取权限类型:1菜单、2功能按钮
     *
     * @return permit_type - 权限类型:1菜单、2功能按钮
     */
    public Integer getPermitType() {
        return permitType;
    }

    /**
     * 设置权限类型:1菜单、2功能按钮
     *
     * @param permitType 权限类型:1菜单、2功能按钮
     */
    public void setPermitType(Integer permitType) {
        this.permitType = permitType;
    }

    /**
     * 获取父级权限Id,顶级菜单权限父级Id为0、功能级权限父级Id为其上级菜单权限Id
     *
     * @return parent_permit_id - 父级权限Id,顶级菜单权限父级Id为0、功能级权限父级Id为其上级菜单权限Id
     */
    public String getParentPermitId() {
        return parentPermitId;
    }

    /**
     * 设置父级权限Id,顶级菜单权限父级Id为0、功能级权限父级Id为其上级菜单权限Id
     *
     * @param parentPermitId 父级权限Id,顶级菜单权限父级Id为0、功能级权限父级Id为其上级菜单权限Id
     */
    public void setParentPermitId(String parentPermitId) {
        this.parentPermitId = parentPermitId;
    }

    /**
     * 获取菜单icon
     *
     * @return icon - 菜单icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单icon
     *
     * @param icon 菜单icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取菜单权限是否为最后一级 0:否、1是
     *
     * @return extremity - 菜单权限是否为最后一级 0:否、1是
     */
    public Integer getExtremity() {
        return extremity;
    }

    /**
     * 设置菜单权限是否为最后一级 0:否、1是
     *
     * @param extremity 菜单权限是否为最后一级 0:否、1是
     */
    public void setExtremity(Integer extremity) {
        this.extremity = extremity;
    }

    /**
     * 获取排序字段
     *
     * @return sort_no - 排序字段
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序字段
     *
     * @param sortNo 排序字段
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取权限地址
     *
     * @return url - 权限地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置权限地址
     *
     * @param url 权限地址
     */
    public void setUrl(String url) {
        this.url = url;
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