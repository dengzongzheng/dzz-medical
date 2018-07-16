package com.dzz.medical.controller.system.common.tools;


import com.dzz.medical.controller.system.domain.bo.PermitBO;
import com.dzz.medical.controller.system.domain.vo.BsMenuVO;
import com.dzz.medical.controller.system.domain.vo.MenuTreeOthData;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * 菜单组装工具
 *
 * @author dzz
 * @version 1.0.0
 * @since 2017年09月15 下午2:44
 */
public class BsMenuBuildTools {

    private static final String BASE_ID="0";

    /**
     * 构建菜单树
     *
     * @param permitBOS 菜单列表
     * @return 菜单树
     */
    public static List<BsMenuVO> buildMenuTree(List<PermitBO> permitBOS,
                                             Map<String, String> permitMap) {


        /*排除第一级菜单*/
        List<PermitBO> noCurrentMenuList = permitBOS.stream()
                .filter(permitBO -> permitBO!=null&&!permitBO.getPermitId().equals(BASE_ID)).collect(Collectors.toList
                ());

        /*获取第一级菜单*/
        List<BsMenuVO> bsMenuVOS = Lists.newArrayList();
        permitBOS.forEach(permitBO -> {
            if (permitBO!=null&&permitBO.getParentPermitId().equals(BASE_ID)) {
                BsMenuVO bsMenuVO = convertToBsMenuVO(permitBO, permitMap);
                List<BsMenuVO> childList = getChildren(permitBO.getPermitId(), noCurrentMenuList, permitMap);
                if (!CollectionUtils.isEmpty(childList)) {
                    bsMenuVO.getState().setSelected(Boolean.FALSE);
                }
                bsMenuVO.setChildren(childList);
                bsMenuVOS.add(bsMenuVO);
            }
        });
        return bsMenuVOS.stream().sorted().collect(Collectors.toList());
    }


    /**
     * 获取子菜单信息
     *
     * @param menuId       父级菜单ID
     * @param permitBOS 菜单列表
     * @return 子菜单
     */
    public static List<BsMenuVO> getChildren(String menuId,
                                           List<PermitBO> permitBOS, Map<String, String> permitMap) {

        /*排除当前级别菜单*/
        List<PermitBO> noCurrentMenuList = permitBOS.stream()
                .filter(permitBO -> !permitBO.getPermitId().equals(menuId)).collect(Collectors.toList());

        /*获取所有menuId下的子菜单*/
        List<BsMenuVO> children = Lists.newArrayList();
        permitBOS.forEach(permitBO -> {
            if (permitBO.getParentPermitId().equals(menuId)) {
                BsMenuVO bsMenuVO = convertToBsMenuVO(permitBO, permitMap);
                List<BsMenuVO> childList = getChildren(permitBO.getPermitId(), noCurrentMenuList, permitMap);
                bsMenuVO.setChildren(childList);
                if (!CollectionUtils.isEmpty(childList)) {
                    bsMenuVO.getState().setSelected(Boolean.FALSE);
                }
                children.add(bsMenuVO);
            }
        });
        return children.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 转换实体信息
     *
     * @param permitBO 菜单实体
     * @return 菜单VO
     */
    public static BsMenuVO convertToBsMenuVO(PermitBO permitBO, Map<String, String> userPermitBOMap) {

        BsMenuVO bsMenuVO = new BsMenuVO();
        BeanUtils.copyProperties(permitBO, bsMenuVO);
        bsMenuVO.setId(permitBO.getPermitId());
        bsMenuVO.setParentId(permitBO.getParentPermitId());
        bsMenuVO.setMenuType(permitBO.getPermitType());

        bsMenuVO.setData(getBsMenuVOData(permitBO));
        if (null != userPermitBOMap && null != userPermitBOMap.get(bsMenuVO.getId())) {
            bsMenuVO.getState().setSelected(Boolean.TRUE);
        }
        return bsMenuVO;
    }

    /**
     * 处理菜单数据中的data.用于前台逻辑
     *
     * @param permitBO 菜单实体
     * @return 菜单树给前台
     */
    public static MenuTreeOthData getBsMenuVOData(PermitBO permitBO) {

        MenuTreeOthData menuTreeOthData = new MenuTreeOthData();
        menuTreeOthData.setExtremity(permitBO.getExtremity().equals(1));
        return menuTreeOthData;
    }

    /**
     * 构建前台菜单树
     *
     * @param bsMenuVOS 菜单对象列表
     * @return 菜单树
     */
    public static String buildPortalMenuTree(List<BsMenuVO> bsMenuVOS) {

        StringBuilder menuTree = new StringBuilder();
        bsMenuVOS.forEach(bsMenuVO -> {
            menuTree.append("<li>");
            menuTree.append(buildAllMenu(bsMenuVO));
            menuTree.append("</li>");
        });
        return menuTree.toString();
    }

    /**
     * 构建菜单
     *
     * @param bsMenuVO 菜单实体
     * @return 菜单
     */
    public static String buildMenu(BsMenuVO bsMenuVO) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bsMenuVO.getExtremity().toString().equals(BASE_ID) ?
                "<a href='" : "<a class='J_menuItem' href='");
        stringBuilder.append(bsMenuVO.getExtremity().toString().equals(BASE_ID) ? "#" : bsMenuVO.getUrl());
        stringBuilder.append("'><i class='");
        stringBuilder.append(bsMenuVO.getIcon());
        stringBuilder.append("'></i><span class='nav-label'>");
        stringBuilder.append(bsMenuVO.getText());
        stringBuilder.append(bsMenuVO.getExtremity().toString().equals(BASE_ID) ?
                "</span><span class='fa arrow'></span></a>" :"</span></a>");
        return stringBuilder.toString();
    }

    /**
     * 构建菜单子菜单
     *
     * @param bsMenuVO 菜单实体
     * @return 子菜单
     */
    public static String buildAllMenu(BsMenuVO bsMenuVO) {

        StringBuilder menu = new StringBuilder();
        if (bsMenuVO.getExtremity().equals(1)) {
            menu.append(buildMenu(bsMenuVO));
        } else {
            menu.append(buildMenu(bsMenuVO));
            menu.append("<ul class='nav nav-second-level'>");
            if (!CollectionUtils.isEmpty(bsMenuVO.getChildren())) {
                bsMenuVO.getChildren().forEach(bsMenuVO1 -> {
                    menu.append("<li>");
                    menu.append(buildAllMenu(bsMenuVO1));
                    menu.append("</li>");
                });
            }
            menu.append("</ul>");
        }

        return menu.toString();
    }

}
