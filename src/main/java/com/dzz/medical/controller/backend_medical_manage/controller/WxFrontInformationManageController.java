package com.dzz.medical.controller.backend_medical_manage.controller;

import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MedicalStatusEnums;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.ToppingEnums;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalInformationDTO;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontInformationManageService;
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
public class WxFrontInformationManageController extends BaseController{


    
    @Autowired
    private WxFrontInformationManageService wxFrontInformationManageService;

    @Autowired
    private UtilConfig utilConfig;

    /**
     * 卫生知识
     * @return 卫生知识介绍
     */
    @RequestMapping(value = "/informationManage", method = RequestMethod.GET)
    public String informationManage(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        map.put("statues", MedicalStatusEnums.getElementList());
        return "/backend_medical_manage/information_manage";
    }

    /**
     * 卫生知识列表
     * @param queryDTO 查询条件
     * @return 列表结果
     */
    @RequestMapping(value = "/listInformation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listMedicalInformation(MedicalListQueryDTO queryDTO) {

        return ResponseEntity.ok(ResponseDzz.ok(wxFrontInformationManageService.listMedicalInformation(queryDTO)));
    }

    /**
     * 去新增卫生知识
     * @param map map
     * @return 卫生知识新增页
     */
    @RequestMapping(value = "/addInformation", method = RequestMethod.GET)
    public String addInformation(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/add_information";
    }

    /**
     * 预览卫生知识
     * @param map map
     * @return 卫生知识预览页
     */
    @RequestMapping(value = "/previewInformation", method = RequestMethod.GET)
    public String previewInformation(ModelMap map,String content,String title) {

        map.put("content", content);
        map.put("title", title);
        map.put("createTime", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        map.put("readCount", Math.round(10000D));
        return "/backend_medical_manage/information_preview";
    }

    /**
     * 新增卫生知识
     * @return 卫生知识管理列表页
     */
    @RequestMapping(value = "/addInformation", method = RequestMethod.POST)
    public String addInformation(AddMedicalDTO addInformationDTO) {

        addInformationDTO.setCreator(getUserAccount());
        addInformationDTO.setUpdater(addInformationDTO.getCreator());
        log.info(addInformationDTO.toString());
        wxFrontInformationManageService.saveInformation(addInformationDTO);
        return "redirect:/manage/informationManage";
    }


    /**
     * 去修改卫生知识
     * @param map map
     * @return 卫生知识修改页
     */
    @RequestMapping(value = "/updateInformation", method = RequestMethod.GET)
    public String updateInformation(ModelMap map,String medicalInformationNo) {

        MedicalInformationDetailBO medicalInformationDetailBO = wxFrontInformationManageService.detailMedicalInformation(medicalInformationNo);

        if (Objects.nonNull(medicalInformationDetailBO)) {
            Iterable<String> it = Splitter.on(";").split(medicalInformationDetailBO.getTitleImages());
            List<String> listTitleImage = Lists.newArrayList(it);
            medicalInformationDetailBO.setListTitleImage(listTitleImage);
        }
        medicalInformationDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalInformationDetailBO.getTextData()));
        medicalInformationDetailBO.setImageServerPath(utilConfig.getImageServerPath());
        map.put("medicalInformationDetailBO", medicalInformationDetailBO);
        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/update_information";
    }

    /**
     * 下线卫生知识
     * @param medicalInformationNo 卫生知识号
     * @return 结果
     */
    @RequestMapping(value = "/offLineInformation", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> offLineInformation(String medicalInformationNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontInformationManageService.updateStatus(medicalInformationNo, MedicalStatusEnums.OFFLINE.getCode())));
    }

    /**
     * 上线卫生知识
     * @param medicalInformationNo 卫生知识号
     * @return 结果
     */
    @RequestMapping(value = "/onLineInformation", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> onLineInformation(String medicalInformationNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontInformationManageService.updateStatus(medicalInformationNo, MedicalStatusEnums.NOMOR.getCode())));
    }



    /**
     * 新增卫生知识
     * @return 卫生知识管理列表页
     */
    @RequestMapping(value = "/updateInformation", method = RequestMethod.POST)
    public String updateInformation(UpdateMedicalInformationDTO updateMedicalInformationDTO) {

        updateMedicalInformationDTO.setUpdater(getUserAccount());
        wxFrontInformationManageService.updateMedicalInformation(updateMedicalInformationDTO);
        return "redirect:/manage/informationManage";
    }
    
}
