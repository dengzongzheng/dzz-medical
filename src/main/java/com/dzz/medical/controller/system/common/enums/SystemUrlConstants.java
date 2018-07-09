package com.dzz.medical.controller.system.common.enums;

/**
 * 系统功能地址
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年03月27 下午6:35
 */
public interface SystemUrlConstants {

    /**菜单管理*/
     String MENU_MANGE = "/menu/menuManage";

    /**新增菜单*/
     String MENU_ADD = "/menu/addMenu";

    /**更新菜单状态*/
     String MENU_UPDATE_STATUS = "/menu/updateMenuStatus";

    /**更新菜单*/
     String MENU_UPDATE = "/menu/updateMenu";

    /**根据菜单ID取菜单信息*/
     String MENU_GET_MENU_BY_ID= "/menu/getMenuById";



    /**角色管理*/
     String ROLE_MANAGE = "/role/roleManage";

    /**搜索角色*/
     String ROLE_SEARCH = "/role/roleSearch";

    /**新增角色*/
     String ROLE_ADD = "/role/addRole";

    /**获取部门角色信息*/
    String GET_DEPARTMENT_ROLES = "/role/getDepartmentRoles";



    /**用户管理*/
     String USER_MANAGE = "/user/userManage";

    /**搜索用户*/
     String USER_SEARCH = "/user/userSearch";

    /**新增用户*/
     String USER_ADD = "/user/addUser";


    /**去用户归属*/
    String TO_USER_BELONG = "/user/toUserBelong";


    /**用户归属*/
    String USER_BELONG = "/user/userBelong";


    /**部门用户信息*/
    String DEPARTMENT_USERS = "/user/departmentUsers";

    /**部门用户信息*/
    String DEPARTMENT_ALL_USERS = "/user/allDepartmentUsers";

    /**用户授权*/
     String USER_MENU_PERMIT = "/user/userMenuPermit";

    /**修改密码*/
     String USER_UPDATE_PASSWORD = "/user/updatePassword";

    /**修改用户状态信息*/
     String USER_UPDATE_STATUS= "/user/updateUserStatus";



    /**部门管理*/
     String DEPARTMENT_MANAGE = "/department/departmentManage";

    /**搜索部门*/
     String DEPARTMENT_SEARCH = "/department/departmentSearch";


    /**新增部门*/
    String TO_DEPARTMENT_ADD = "/department/toAddDepartment";

    /**新增部门*/
     String DEPARTMENT_ADD = "/department/addDepartment";

    /**部门授权*/
     String DEPARTMENT_PERMIT = "/department/departmentPermit";


    /**去修改部门*/
    String TO_DEPARTMENT_UPDATE = "/department/toUpdateDepartment";

    /**修改部门*/
     String DEPARTMENT_UPDATE = "/department/updateDepartment";


}
