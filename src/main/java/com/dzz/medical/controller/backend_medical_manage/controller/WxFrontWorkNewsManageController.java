package com.dzz.medical.controller.backend_medical_manage.controller;

import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MedicalStatusEnums;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.ToppingEnums;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalWorkNewsDTO;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontWorkNewsManageService;
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
public class WxFrontWorkNewsManageController extends BaseController{


    
    @Autowired
    private WxFrontWorkNewsManageService wxFrontWorkNewsManageService;

    @Autowired
    private UtilConfig utilConfig;

    /**
     * 工作动态
     * @return 工作动态介绍
     */
    @RequestMapping(value = "/workNewsManage", method = RequestMethod.GET)
    public String workNewsManage(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        map.put("statues", MedicalStatusEnums.getElementList());
        return "/backend_medical_manage/work_news/work_news_manage";
    }

    /**
     * 工作动态列表
     * @param queryDTO 查询条件
     * @return 列表结果
     */
    @RequestMapping(value = "/listWorkNews", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listMedicalWorkNews(MedicalListQueryDTO queryDTO) {

        return ResponseEntity.ok(ResponseDzz.ok(wxFrontWorkNewsManageService.listMedicalWorkNews(queryDTO)));
    }

    /**
     * 去新增工作动态
     * @param map map
     * @return 工作动态新增页
     */
    @RequestMapping(value = "/addWorkNews", method = RequestMethod.GET)
    public String addWorkNews(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/work_news/add_work_news";
    }

    /**
     * 预览工作动态
     * @param map map
     * @return 工作动态预览页
     */
    @RequestMapping(value = "/previewWorkNews", method = RequestMethod.GET)
    public String previewWorkNews(ModelMap map,String content,String title) {

        map.put("content", content);
        map.put("title", title);
        map.put("createTime", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        map.put("readCount", Math.round(10000D));
        return "/backend_medical_manage/work_news/work_news_preview";
    }

    /**
     * 新增工作动态
     * @return 工作动态管理列表页
     */
    @RequestMapping(value = "/addWorkNews", method = RequestMethod.POST)
    public String addWorkNews(AddMedicalDTO addWorkNewsDTO) {

        addWorkNewsDTO.setCreator(getUserAccount());
        addWorkNewsDTO.setUpdater(addWorkNewsDTO.getCreator());
        log.info(addWorkNewsDTO.toString());
        wxFrontWorkNewsManageService.saveWorkNews(addWorkNewsDTO);
        return "redirect:/manage/workNewsManage";
    }


    /**
     * 去修改工作动态
     * @param map map
     * @return 工作动态修改页
     */
    @RequestMapping(value = "/updateWorkNews", method = RequestMethod.GET)
    public String updateWorkNews(ModelMap map,String medicalWorkNewsNo) {

        MedicalWorkNewsDetailBO medicalWorkNewsDetailBO = wxFrontWorkNewsManageService.detailMedicalWorkNews(medicalWorkNewsNo);

        if (Objects.nonNull(medicalWorkNewsDetailBO)) {
            Iterable<String> it = Splitter.on(";").split(medicalWorkNewsDetailBO.getTitleImages());
            List<String> listTitleImage = Lists.newArrayList(it);
            medicalWorkNewsDetailBO.setListTitleImage(listTitleImage);
        }
        medicalWorkNewsDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalWorkNewsDetailBO.getTextData()));
        medicalWorkNewsDetailBO.setImageServerPath(utilConfig.getImageServerPath());
        map.put("medicalWorkNewsDetailBO", medicalWorkNewsDetailBO);
        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/work_news/update_work_news";
    }

    /**
     * 下线工作动态
     * @param medicalWorkNewsNo 工作动态号
     * @return 结果
     */
    @RequestMapping(value = "/offLineWorkNews", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> offLineWorkNews(String medicalWorkNewsNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontWorkNewsManageService.updateStatus(medicalWorkNewsNo, MedicalStatusEnums.OFFLINE.getCode())));
    }

    /**
     * 上线工作动态
     * @param medicalWorkNewsNo 工作动态号
     * @return 结果
     */
    @RequestMapping(value = "/onLineWorkNews", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> onLineWorkNews(String medicalWorkNewsNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontWorkNewsManageService.updateStatus(medicalWorkNewsNo, MedicalStatusEnums.NOMOR.getCode())));
    }



    /**
     * 新增工作动态
     * @return 工作动态管理列表页
     */
    @RequestMapping(value = "/updateWorkNews", method = RequestMethod.POST)
    public String updateWorkNews(UpdateMedicalWorkNewsDTO updateMedicalWorkNewsDTO) {

        updateMedicalWorkNewsDTO.setUpdater(getUserAccount());
        wxFrontWorkNewsManageService.updateMedicalWorkNews(updateMedicalWorkNewsDTO);
        return "redirect:/manage/workNewsManage";
    }
    
}
