package com.dzz.medical.controller.frontend_medical.controller;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListInformationBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListNoticeBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListWorkNewsBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;
import com.dzz.medical.controller.frontend_medical.service.MedicalBroadcastService;
import com.dzz.medical.controller.util.service.RedisToolService;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 卫监播报控制层
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月09 下午10:58
 */
@Controller
@RequestMapping("/broadcast")
public class MedicalBroadcastController {

    @Autowired
    private MedicalBroadcastService medicalBroadcastService;

    @Autowired
    private UtilConfig utilConfig;

    @Autowired
    private RedisToolService redisToolService;

    /**
     * 通知列表查询
     * @param query 查询条件
     * @return 结果
     */
    @RequestMapping(value = "/listNotice", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listNotice(ListQueryDTO query) {

        PageUtil<ListNoticeBO> pageUtil = medicalBroadcastService.listNotice(query);
        List<ListNoticeBO> legalBOList = pageUtil.getData();
        if (!CollectionUtils.isEmpty(legalBOList)) {
            Splitter splitter = Splitter.on(";").omitEmptyStrings();
            List<String> titleImageList;
            for (ListNoticeBO listNoticeBO : legalBOList) {
                listNoticeBO.setReadCount(redisToolService.getReadCount(listNoticeBO.getNoticeNo()));
                listNoticeBO.setImageServerPath(utilConfig.getImageServerPath());
                titleImageList = Lists.newArrayList(splitter.split(listNoticeBO.getTitleImages()));
                if (titleImageList.size() == 1) {
                    listNoticeBO.setIsOneImage(Boolean.TRUE);
                    listNoticeBO.setOneTitleImage(titleImageList.get(0));
                }else{
                    listNoticeBO.setIsOneImage(Boolean.FALSE);
                }
                listNoticeBO.setListTitleImage(titleImageList);
                listNoticeBO.setTitleImages("");
            }
        }
        return ResponseEntity.ok(ResponseDzz.ok(pageUtil));
    }


    /**
     * 通知列表
     * @return 通知列表页
     */
    @RequestMapping(value = "/noticeDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> noticeDetails(String medicalNo,ModelMap map) {

        MedicalNoticeDetailBO medicalNoticeDetailBO = medicalBroadcastService.detailMedicalNotice(medicalNo);
        medicalNoticeDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalNoticeDetailBO.getTextData()));
        medicalNoticeDetailBO.setReadCount(redisToolService.readCountRecord(medicalNo));
        return ResponseEntity.ok(ResponseDzz.ok(medicalNoticeDetailBO));
    }


    /**
     * 卫生知识列表查询
     * @param query 查询条件
     * @return 结果
     */
    @RequestMapping(value = "/listInformation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listInformation(ListQueryDTO query) {

        PageUtil<ListInformationBO> pageUtil = medicalBroadcastService.listInformation(query);
        List<ListInformationBO> informationBOList = pageUtil.getData();
        if (!CollectionUtils.isEmpty(informationBOList)) {
            Splitter splitter = Splitter.on(";").omitEmptyStrings();
            List<String> titleImageList;
            for (ListInformationBO listInformationBO : informationBOList) {
                listInformationBO.setReadCount(redisToolService.getReadCount(listInformationBO.getInformationNo()));
                listInformationBO.setImageServerPath(utilConfig.getImageServerPath());
                titleImageList = Lists.newArrayList(splitter.split(listInformationBO.getTitleImages()));
                if (titleImageList.size() == 1) {
                    listInformationBO.setIsOneImage(Boolean.TRUE);
                    listInformationBO.setOneTitleImage(titleImageList.get(0));
                }else{
                    listInformationBO.setIsOneImage(Boolean.FALSE);
                }
                listInformationBO.setListTitleImage(titleImageList);
                listInformationBO.setTitleImages("");
            }
        }
        return ResponseEntity.ok(ResponseDzz.ok(pageUtil));
    }


    /**
     * 卫生知识列表
     * @return 通知列表页
     */
    @RequestMapping(value = "/informationDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> informationDetails(String medicalNo,ModelMap map) {

        MedicalInformationDetailBO medicalInformationDetailBO = medicalBroadcastService.detailMedicalInformation(medicalNo);
        medicalInformationDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalInformationDetailBO.getTextData()));
        medicalInformationDetailBO.setReadCount(redisToolService.readCountRecord(medicalNo));
        return ResponseEntity.ok(ResponseDzz.ok(medicalInformationDetailBO));
    }


    /**
     * 工作动态列表查询
     * @param query 查询条件
     * @return 结果
     */
    @RequestMapping(value = "/listWorkNews", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listWorkNews(ListQueryDTO query) {

        PageUtil<ListWorkNewsBO> pageUtil = medicalBroadcastService.listWorkNews(query);
        List<ListWorkNewsBO> workNewsBOList = pageUtil.getData();
        if (!CollectionUtils.isEmpty(workNewsBOList)) {
            Splitter splitter = Splitter.on(";").omitEmptyStrings();
            List<String> titleImageList;
            for (ListWorkNewsBO listWorkNewsBO : workNewsBOList) {
                listWorkNewsBO.setReadCount(redisToolService.getReadCount(listWorkNewsBO.getWorkNewsNo()));
                listWorkNewsBO.setImageServerPath(utilConfig.getImageServerPath());
                titleImageList = Lists.newArrayList(splitter.split(listWorkNewsBO.getTitleImages()));
                if (titleImageList.size() == 1) {
                    listWorkNewsBO.setIsOneImage(Boolean.TRUE);
                    listWorkNewsBO.setOneTitleImage(titleImageList.get(0));
                }else{
                    listWorkNewsBO.setIsOneImage(Boolean.FALSE);
                }
                listWorkNewsBO.setListTitleImage(titleImageList);
                listWorkNewsBO.setTitleImages("");
            }
        }
        return ResponseEntity.ok(ResponseDzz.ok(pageUtil));
    }


    /**
     * 工作动态列表
     * @return 工作动态列表页
     */
    @RequestMapping(value = "/workNewsDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> workNewsDetails(String medicalNo,ModelMap map) {

        MedicalWorkNewsDetailBO medicalWorkNewsDetailBO = medicalBroadcastService.detailMedicalWorkNews(medicalNo);
        medicalWorkNewsDetailBO.setTextData(StringEscapeUtils.unescapeHtml4(medicalWorkNewsDetailBO.getTextData()));
        medicalWorkNewsDetailBO.setReadCount(redisToolService.readCountRecord(medicalNo));
        return ResponseEntity.ok(ResponseDzz.ok(medicalWorkNewsDetailBO));
    }

}
