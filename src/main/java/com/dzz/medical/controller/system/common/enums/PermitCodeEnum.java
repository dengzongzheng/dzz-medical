package com.dzz.medical.controller.system.common.enums;

import com.dzz.medical.controller.util.domain.dto.ConstantBean;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;

/**
 * 权限管理枚举码表
 *
 * @author 何红霞~Angelina
 * @version 1.0.0
 * @since 2018年4月19日 09点33分
 */
public interface PermitCodeEnum {

    enum RoleType {
        ADMIN(1, "超级管理员"), PERSON_IN_CHARGE(2, "部门负责人"),
        MANAGER(3, "部门主管"), STAFF(4, "部门员工");
        private Integer code;

        private String name;

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        RoleType(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        /**
         * 获取当前枚举的属性列表
         *
         * @return 属性列表
         */
        public static List<ConstantBean> getElementList() {
            List<ConstantBean> list = Lists.newArrayList();
            for (RoleType property : RoleType.values()) {
                if(Objects.equals(property.getCode(),ADMIN.getCode())){
                    continue;
                }
                ConstantBean constantBean = new ConstantBean();
                constantBean.setCode(property.code);
                constantBean.setName(property.name);
                list.add(constantBean);
            }
            return list;
        }

        /**
         * 根据code取名称
         *
         * @param code code
         * @return 名称
         */
        public static String getNameByCode(Integer code) {
            for (RoleType property : RoleType.values()) {
                if (code.equals(property.code)) {
                    return property.name;
                }
            }
            return "";
        }
    }
}

