package com.dzz.medical.controller.backend_medical_manage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.config.wx.WxConfig;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MedicalStatusEnums;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.ToppingEnums;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalLegalDTO;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontLegalManageService;
import com.dzz.medical.controller.backend_medical_manage.service.WxService;
import com.dzz.medical.controller.util.controller.BaseController;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信前台管理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月20 上午7:39
 */
@Controller
@RequestMapping("/manage")
@Slf4j
public class WxFrontLegalManageController extends BaseController{


    @Autowired
    private WxService wxService;

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private WxFrontLegalManageService wxFrontManageService;

    @Autowired
    private UtilConfig utilConfig;

    /**
     * 法律法规
     * @return 法律法规介绍
     */
    @RequestMapping(value = "/legalManage", method = RequestMethod.GET)
    public String legalManage(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        map.put("statues", MedicalStatusEnums.getElementList());
        return "/backend_medical_manage/legal/legal_manage";
    }

    /**
     * 法律法规列表
     * @param queryDTO 查询条件
     * @return 列表结果
     */
    @RequestMapping(value = "/listLegal", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listMedicalLegal(MedicalListQueryDTO queryDTO) {

        return ResponseEntity.ok(ResponseDzz.ok(wxFrontManageService.listMedicalLegal(queryDTO)));
    }

    /**
     * 去新增法律法规
     * @param map map
     * @return 法律法规新增页
     */
    @RequestMapping(value = "/addLegal", method = RequestMethod.GET)
    public String addLegal(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/legal/add_legal";
    }

    /**
     * 预览法律法规
     * @param map map
     * @return 法律法规预览页
     */
    @RequestMapping(value = "/previewLegal", method = RequestMethod.GET)
    public String previewLegal(ModelMap map,String content,String title) {

        map.put("content", content);
        map.put("title", title);
        map.put("createTime", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        map.put("readCount", Math.round(10000D));
        return "/backend_medical_manage/legal/legal_preview";
    }

    /**
     * 新增法律法规
     * @return 法律法规管理列表页
     */
    @RequestMapping(value = "/addLegal", method = RequestMethod.POST)
    public String addLegal(AddMedicalDTO addLegalDTO) {

        addLegalDTO.setCreator(getUserAccount());
        addLegalDTO.setUpdater(addLegalDTO.getCreator());
        log.info(addLegalDTO.toString());
        wxFrontManageService.saveLegal(addLegalDTO);
        return "redirect:/manage/legal/legalManage";
    }


    /**
     * 去修改法律法规
     * @param map map
     * @return 法律法规修改页
     */
    @RequestMapping(value = "/updateLegal", method = RequestMethod.GET)
    public String updateLegal(ModelMap map,String medicalLegalNo) {

        MedicalLegalDetailBO medicalLegalDetailBO = wxFrontManageService.detailMedicalLegal(medicalLegalNo);

        if (Objects.nonNull(medicalLegalDetailBO)) {
            Iterable<String> it = Splitter.on(";").split(medicalLegalDetailBO.getTitleImages());
            List<String> listTitleImage = Lists.newArrayList(it);
            medicalLegalDetailBO.setListTitleImage(listTitleImage);
        }
        medicalLegalDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalLegalDetailBO.getTextData()));
        medicalLegalDetailBO.setImageServerPath(utilConfig.getImageServerPath());
        map.put("medicalLegalDetailBO", medicalLegalDetailBO);
        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/legal/update_legal";
    }

    /**
     * 下线法律法规
     * @param medicalLegalNo 法律法规号
     * @return 结果
     */
    @RequestMapping(value = "/offLineLegal", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> offLineLegal(String medicalLegalNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontManageService.updateStatus(medicalLegalNo, MedicalStatusEnums.OFFLINE.getCode())));
    }

    /**
     * 上线法律法规
     * @param medicalLegalNo 法律法规号
     * @return 结果
     */
    @RequestMapping(value = "/onLineLegal", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> onLineLegal(String medicalLegalNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontManageService.updateStatus(medicalLegalNo, MedicalStatusEnums.NOMOR.getCode())));
    }



    /**
     * 新增法律法规
     * @return 法律法规管理列表页
     */
    @RequestMapping(value = "/updateLegal", method = RequestMethod.POST)
    public String updateLegal(UpdateMedicalLegalDTO updateMedicalLegalDTO) {

        updateMedicalLegalDTO.setUpdater(getUserAccount());
        wxFrontManageService.updateMedicalLegal(updateMedicalLegalDTO);
        return "redirect:/manage/legalManage";
    }

    /**
     * 创建菜单信息
     */
    @RequestMapping(value = "/createMenu", method = RequestMethod.GET)
    public void createMenu() {

        ResponseDzz responseDzz = wxService.deleteMenu();
        if (responseDzz.checkFail()) {
            log.error("删除菜单失败，不能进行添加菜单。失败原因:{}", responseDzz.getMessage());
            return;
        }
        JSONObject menuJSON = new JSONObject();
        JSONObject firstMenuJSON = wxService.createMenuJSONObject("为您服务","","","");
        JSONArray firstMenuJSONSub = new JSONArray();
        JSONObject firstSub1 = wxService.createMenuJSONObject("我要投诉","click","", "V1001_TODAY_MUSIC");
        JSONObject firstSub2 = wxService.createMenuJSONObject("办事指南","click","","V1002_TODAY_MUSIC");
        JSONObject firstSub3 = wxService.createMenuJSONObject("法律法规","view",wxConfig.getMServerPath() + "/for-service/legal","");
        firstMenuJSONSub.add(firstSub1);
        firstMenuJSONSub.add(firstSub2);
        firstMenuJSONSub.add(firstSub3);
        firstMenuJSON.put("sub_button", firstMenuJSONSub);

        JSONObject secondMenuJSON = wxService.createMenuJSONObject("卫监播报","","","");
        JSONArray secondMenuJSONSub = new JSONArray();
        JSONObject secondSub1 = wxService.createMenuJSONObject("通知公告","view",wxConfig.getMServerPath() + "/broadcast/notice","");
        JSONObject secondSub2 = wxService.createMenuJSONObject("工作动态","view",wxConfig.getMServerPath() + "/broadcast/work-news","");
        JSONObject secondSub3 = wxService.createMenuJSONObject("卫生知识","view",wxConfig.getMServerPath() + "/broadcast/medical-informations","");
        JSONObject secondSub4 = wxService.createMenuJSONObject("关于我们","view",wxConfig.getMServerPath() + "/broadcast/about-me","");
        secondMenuJSONSub.add(secondSub1);
        secondMenuJSONSub.add(secondSub2);
        secondMenuJSONSub.add(secondSub3);
        secondMenuJSONSub.add(secondSub4);
        secondMenuJSON.put("sub_button", secondMenuJSONSub);

        JSONObject thirdMenuJSON = wxService.createMenuJSONObject("诚信自律","","","");
        JSONArray thirdMenuJSONSub = new JSONArray();
        JSONObject thirdSub1 = wxService.createMenuJSONObject("公共场所","view",wxConfig.getServerPath() + "/honesty/publicPlace","");
        JSONObject thirdSub2 = wxService.createMenuJSONObject("学校卫生","view",wxConfig.getServerPath() + "/honesty/schoolPlace","");
        JSONObject thirdSub3 = wxService.createMenuJSONObject("医疗机构","view",wxConfig.getServerPath() + "/honesty/medicalPlace","");
        JSONObject thirdSub4 = wxService.createMenuJSONObject("供水单位","view",wxConfig.getServerPath() + "/honesty/waterSupplyPlace","");
        JSONObject thirdSub5 = wxService.createMenuJSONObject("监督管理","view",wxConfig.getServerPath() + "/honesty/controlManage","");
        thirdMenuJSONSub.add(thirdSub1);
        thirdMenuJSONSub.add(thirdSub2);
        thirdMenuJSONSub.add(thirdSub3);
        thirdMenuJSONSub.add(thirdSub4);
        thirdMenuJSONSub.add(thirdSub5);
        thirdMenuJSON.put("sub_button", thirdMenuJSONSub);

        JSONArray buttonArray = new JSONArray();
        buttonArray.add(firstMenuJSON);
        buttonArray.add(secondMenuJSON);
        buttonArray.add(thirdMenuJSON);

        menuJSON.put("button", buttonArray);

        log.info("菜单新建结果:{}", wxService.createMenu(menuJSON.toJSONString()).toString());
    }

}
