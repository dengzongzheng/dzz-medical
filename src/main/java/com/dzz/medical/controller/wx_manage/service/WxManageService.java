package com.dzz.medical.controller.wx_manage.service;

import com.dzz.medical.common.ResponseDzz;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.wx_manage.api.MenuAPI;
import com.dzz.medical.controller.wx_manage.api.TokenAPI;
import com.dzz.medical.controller.wx_manage.domain.model.menu.Menu;
import com.dzz.medical.controller.wx_manage.domain.model.menu.button.Button;
import com.dzz.medical.controller.wx_manage.domain.model.menu.button.ComplexButton;
import com.dzz.medical.controller.wx_manage.domain.model.menu.button.ViewButton;
import com.dzz.medical.controller.wx_manage.domain.model.token.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信相关管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:17
 */
@Service
@Slf4j
public class WxManageService {

    @Autowired
    private WxConfig wxConfig;

    /**
     * 创建菜单
     * @return 创建结果
     */
    public ResponseDzz createMenu() {

        // 调用接口获取access_token
        Token token = TokenAPI.getAccessTokenForBasicSupport(wxConfig.getAppId(), wxConfig.getAppSecret());
        if (null != token) {
            String access_token = token.getAccess_token();
            // 调用菜单删除接口
            MenuAPI.deleteMenu(access_token);
            // 调用菜单创建接口
            int result = MenuAPI.createMenu(getMenu(), access_token);
            // 判断菜单创建结果
            if (0 == result) {
                log.info("创建自定义菜单成功");
            } else {
                log.info("创建自定义菜单失败, 错误码: " + result);
            }
        }
        return ResponseDzz.ok();
    }

    /**
     * 组装菜单数据
     *
     * @return 菜单实例
     */
    private Menu getMenu() {

        //为您服务
        ViewButton btn1 = new ViewButton();
        btn1.setName("为您服务");
        btn1.setType("view");
        btn1.setUrl(wxConfig.getServerPath() + "/product/index");


        ViewButton btn2 = new ViewButton();
        btn2.setName("卫监播报");
        btn2.setType("view");
        btn2.setUrl("http://mp.weixin.qq.com/s/OQUdFnLWY3sT8HlsqlUCEg");


        // 诚信自律子菜单(项)
        ViewButton btn31 = new ViewButton();
        btn31.setName("监督协管");
        btn31.setType("view");
        btn31.setUrl("http://mp.weixin.qq.com/s/77uVlE0xme3Of3A2uzGG_g");

        ViewButton btn32 = new ViewButton();
        btn32.setName("放射卫生");
        btn32.setType("view");
        btn32.setUrl("http://mp.weixin.qq.com/s/OQUdFnLWY3sT8HlsqlUCEg");

        ViewButton btn33 = new ViewButton();
        btn33.setName("传染病防");
        btn33.setType("view");
        btn33.setUrl(wxConfig.getServerPath() + "/product/list");


        ViewButton btn34 = new ViewButton();
        btn34.setName("学校卫生");
        btn34.setType("view");
        btn34.setUrl(wxConfig.getServerPath() + "/product/list");


        ViewButton btn35 = new ViewButton();
        btn35.setName("公共场所");
        btn35.setType("view");
        btn35.setUrl(wxConfig.getServerPath() + "/product/list");


        // 诚信自律
        ComplexButton btn3 = new ComplexButton();
        btn3.setName("诚信自律");
        btn3.setSub_button(new Button[] {btn35, btn34, btn33, btn32,btn31 });


        // 菜单实例
        Menu menu = new Menu();
        menu.setButton(new Button[] { btn1, btn2, btn3 });

        return menu;
    }

}
