package com.dzz.medical.controller.system.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "bs_admin_role")
public class BsAdminRole {
    /**
     * 主键ID
     */
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 角色Id
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 角色类型
     */
    @Column(name="role_type")
    private Integer roleType;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 部门Id
     */
    @Column(name = "department_id")
    private String departmentId;

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
     * 获取角色类型
     * @return  角色类型
     */
    public Integer getRoleType(){
        return this.roleType;
    }

    /**
     * 设置角色类型
     * @param roleType 角色类型
     */
    public void setRoleType(Integer roleType){
        this.roleType=roleType;
    }

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
     * 获取角色Id
     *
     * @return role_id - 角色Id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色Id
     *
     * @param roleId 角色Id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取部门Id
     *
     * @return department_id - 部门Id
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门Id
     *
     * @param departmentId 部门Id
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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