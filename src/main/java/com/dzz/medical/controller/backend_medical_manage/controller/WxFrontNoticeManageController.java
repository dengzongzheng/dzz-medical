package com.dzz.medical.controller.backend_medical_manage.controller;

import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MedicalStatusEnums;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.ToppingEnums;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalNoticeDTO;
import com.dzz.medical.controller.backend_medical_manage.service.WxFrontNoticeManageService;
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
public class WxFrontNoticeManageController extends BaseController{


    
    @Autowired
    private WxFrontNoticeManageService wxFrontNoticeManageService;

    @Autowired
    private UtilConfig utilConfig;

    /**
     * 通知
     * @return 通知介绍
     */
    @RequestMapping(value = "/noticeManage", method = RequestMethod.GET)
    public String noticeManage(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        map.put("statues", MedicalStatusEnums.getElementList());
        return "/backend_medical_manage/notice/notice_manage";
    }

    /**
     * 通知列表
     * @param queryDTO 查询条件
     * @return 列表结果
     */
    @RequestMapping(value = "/listNotice", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listMedicalNotice(MedicalListQueryDTO queryDTO) {

        return ResponseEntity.ok(ResponseDzz.ok(wxFrontNoticeManageService.listMedicalNotice(queryDTO)));
    }

    /**
     * 去新增通知
     * @param map map
     * @return 通知新增页
     */
    @RequestMapping(value = "/addNotice", method = RequestMethod.GET)
    public String addNotice(ModelMap map) {

        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/notice/add_notice";
    }

    /**
     * 预览通知
     * @param map map
     * @return 通知预览页
     */
    @RequestMapping(value = "/previewNotice", method = RequestMethod.GET)
    public String previewNotice(ModelMap map,String content,String title) {

        map.put("content", content);
        map.put("title", title);
        map.put("createTime", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        map.put("readCount", Math.round(10000D));
        return "/backend_medical_manage/notice/notice_preview";
    }

    /**
     * 新增通知
     * @return 通知管理列表页
     */
    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    public String addNotice(AddMedicalDTO addNoticeDTO) {

        addNoticeDTO.setCreator(getUserAccount());
        addNoticeDTO.setUpdater(addNoticeDTO.getCreator());
        log.info(addNoticeDTO.toString());
        wxFrontNoticeManageService.saveNotice(addNoticeDTO);
        return "redirect:/manage/noticeManage";
    }


    /**
     * 去修改通知
     * @param map map
     * @return 通知修改页
     */
    @RequestMapping(value = "/updateNotice", method = RequestMethod.GET)
    public String updateNotice(ModelMap map,String medicalNoticeNo) {

        MedicalNoticeDetailBO medicalNoticeDetailBO = wxFrontNoticeManageService.detailMedicalNotice(medicalNoticeNo);

        if (Objects.nonNull(medicalNoticeDetailBO)) {
            Iterable<String> it = Splitter.on(";").split(medicalNoticeDetailBO.getTitleImages());
            List<String> listTitleImage = Lists.newArrayList(it);
            medicalNoticeDetailBO.setListTitleImage(listTitleImage);
        }
        medicalNoticeDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalNoticeDetailBO.getTextData()));
        medicalNoticeDetailBO.setImageServerPath(utilConfig.getImageServerPath());
        map.put("medicalNoticeDetailBO", medicalNoticeDetailBO);
        map.put("toppings", ToppingEnums.getElementList());
        return "/backend_medical_manage/notice/update_notice";
    }

    /**
     * 下线通知
     * @param medicalNoticeNo 通知号
     * @return 结果
     */
    @RequestMapping(value = "/offLineNotice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> offLineNotice(String medicalNoticeNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontNoticeManageService.updateStatus(medicalNoticeNo, MedicalStatusEnums.OFFLINE.getCode())));
    }

    /**
     * 上线通知
     * @param medicalNoticeNo 通知号
     * @return 结果
     */
    @RequestMapping(value = "/onLineNotice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> onLineNotice(String medicalNoticeNo) {

        return ResponseEntity.ok(ResponseDzz
                .ok(wxFrontNoticeManageService.updateStatus(medicalNoticeNo, MedicalStatusEnums.NOMOR.getCode())));
    }



    /**
     * 新增通知
     * @return 通知管理列表页
     */
    @RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
    public String updateNotice(UpdateMedicalNoticeDTO updateMedicalNoticeDTO) {

        updateMedicalNoticeDTO.setUpdater(getUserAccount());
        wxFrontNoticeManageService.updateMedicalNotice(updateMedicalNoticeDTO);
        return "redirect:/manage/noticeManage";
    }
    
}
