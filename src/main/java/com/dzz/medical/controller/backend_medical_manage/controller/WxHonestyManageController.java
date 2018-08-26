package com.dzz.medical.controller.backend_medical_manage.controller;

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
 * 诚信管理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月20 上午7:39
 */
@Controller
@RequestMapping("/manage")
@Slf4j
public class WxHonestyManageController extends BaseController{


    @Autowired
    private WxService wxService;

    @Autowired
    private WxConfig wxConfig;

    @Autowired
    private WxFrontLegalManageService wxFrontManageService;

    @Autowired
    private UtilConfig utilConfig;

    /**
     * 诚信
     * @return 诚信介绍
     */
    @RequestMapping(value = "/honestyManage", method = RequestMethod.GET)
    public String honestyManage(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        map.put("statues", MedicalStatusEnums.getElementList());
        return "/backend_medical_manage/honesty/honesty_manage";
    }

    /**
     * 诚信列表
     * @param queryDTO 查询条件
     * @return 列表结果
     */
    @RequestMapping(value = "/listHonesty", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listMedicalHonesty(MedicalListQueryDTO queryDTO) {

        return ResponseEntity.ok(ResponseDzz.ok(wxFrontManageService.listMedicalLegal(queryDTO)));
    }

    /**
     * 去新增诚信
     * @param map map
     * @return 诚信新增页
     */
    @RequestMapping(value = "/addHonesty", method = RequestMethod.GET)
    public String addHonesty(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/honesty/add_honesty";
    }

    /**
     * 预览诚信
     * @param map map
     * @return 诚信预览页
     */
    @RequestMapping(value = "/previewHonesty", method = RequestMethod.GET)
    public String previewHonesty(ModelMap map,String content,String title) {

        map.put("content", content);
        map.put("title", title);
        map.put("createTime", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        map.put("readCount", Math.round(10000D));
        return "/backend_medical_manage/honesty/honesty_preview";
    }

    /**
     * 新增诚信
     * @return 诚信管理列表页
     */
    @RequestMapping(value = "/addHonesty", method = RequestMethod.POST)
    public String addHonesty(AddMedicalDTO addHonestyDTO) {

        addHonestyDTO.setCreator(getUserAccount());
        addHonestyDTO.setUpdater(addHonestyDTO.getCreator());
        log.info(addHonestyDTO.toString());
        wxFrontManageService.saveLegal(addHonestyDTO);
        return "redirect:/manage/honesty/honestyManage";
    }


    /**
     * 去修改诚信
     * @param map map
     * @return 诚信修改页
     */
    @RequestMapping(value = "/updateHonesty", method = RequestMethod.GET)
    public String updateHonesty(ModelMap map,String medicalHonestyNo) {

        MedicalLegalDetailBO medicalHonestyDetailBO = wxFrontManageService.detailMedicalLegal(medicalHonestyNo);

        if (Objects.nonNull(medicalHonestyDetailBO)) {
            Iterable<String> it = Splitter.on(";").split(medicalHonestyDetailBO.getTitleImages());
            List<String> listTitleImage = Lists.newArrayList(it);
            medicalHonestyDetailBO.setListTitleImage(listTitleImage);
        }
        medicalHonestyDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalHonestyDetailBO.getTextData()));
        medicalHonestyDetailBO.setImageServerPath(utilConfig.getImageServerPath());
        map.put("medicalHonestyDetailBO", medicalHonestyDetailBO);
        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/honesty/update_honesty";
    }

    /**
     * 下线诚信
     * @param medicalHonestyNo 诚信号
     * @return 结果
     */
    @RequestMapping(value = "/offLineHonesty", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> offLineHonesty(String medicalHonestyNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontManageService.updateStatus(medicalHonestyNo, MedicalStatusEnums.OFFLINE.getCode())));
    }

    /**
     * 上线诚信
     * @param medicalHonestyNo 诚信号
     * @return 结果
     */
    @RequestMapping(value = "/onLineHonesty", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> onLineHonesty(String medicalHonestyNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontManageService.updateStatus(medicalHonestyNo, MedicalStatusEnums.NOMOR.getCode())));
    }



    /**
     * 新增诚信
     * @return 诚信管理列表页
     */
    @RequestMapping(value = "/updateHonesty", method = RequestMethod.POST)
    public String updateHonesty(UpdateMedicalLegalDTO updateMedicalHonestyDTO) {

        updateMedicalHonestyDTO.setUpdater(getUserAccount());
        wxFrontManageService.updateMedicalLegal(updateMedicalHonestyDTO);
        return "redirect:/manage/honestyManage";
    }

}
