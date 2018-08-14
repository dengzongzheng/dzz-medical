package com.dzz.medical.controller.frontend_medical.controller;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListLegalBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListLegalQueryDTO;
import com.dzz.medical.controller.frontend_medical.service.ServiceForYouService;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 为您服务控制层
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月09 下午10:56
 */
@Controller
@RequestMapping("/forService")
public class ServiceForYouController {

    @Autowired
    private ServiceForYouService serviceForYouService;

    @Autowired
    private UtilConfig utilConfig;

    /**
     * 法律法规
     * @return 法律法规介绍
     */
    @RequestMapping(value = "/legal", method = RequestMethod.GET)
    public String legal() {

        return "/frontend_medical/for_service/legal";
    }

    /**
     * 法律法规列表
     * @return 法律法规列表页
     */
    @RequestMapping(value = "/legalList", method = RequestMethod.GET)
    public String legalList() {

        return "/frontend_medical/for_service/legal_list";
    }


    /**
     * 法律法规列表查询
     * @param query 查询条件
     * @return 结果
     */
    @RequestMapping(value = "/listLegal", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> listLegal(ListLegalQueryDTO query) {

        PageUtil<ListLegalBO> pageUtil = serviceForYouService.listLegal(query);
        List<ListLegalBO> legalBOList = pageUtil.getData();
        if (!CollectionUtils.isEmpty(legalBOList)) {
            Splitter splitter = Splitter.on(";").omitEmptyStrings();
            List<String> titleImageList;
            for (ListLegalBO listLegalBO : legalBOList) {
                listLegalBO.setImageServerPath(utilConfig.getImageServerPath());
                titleImageList = Lists.newArrayList(splitter.split(listLegalBO.getTitleImages()));
                if (titleImageList.size() == 1) {
                    listLegalBO.setIsOneImage(Boolean.TRUE);
                    listLegalBO.setOneTitleImage(titleImageList.get(0));
                }else{
                    listLegalBO.setIsOneImage(Boolean.FALSE);
                }
                listLegalBO.setListTitleImage(titleImageList);
                listLegalBO.setTitleImages("");
            }
            pageUtil.setData(legalBOList);
        }
        return ResponseEntity.ok(ResponseDzz.ok(pageUtil));
    }


    /**
     * 法律法规列表
     * @return 法律法规列表页
     */
    @RequestMapping(value = "/legalDetail", method = RequestMethod.GET)
    public String legalDetail(String medicalLegalNo,ModelMap map) {

        MedicalLegalDetailBO medicalLegalDetailBO = serviceForYouService.detailMedicalLegal(medicalLegalNo);
        map.put("medicalLegalDetailBO", medicalLegalDetailBO);
        return "/frontend_medical/for_service/legal_detail";
    }


    /**
     * 法律法规列表
     * @return 法律法规列表页
     */
    @RequestMapping(value = "/legalDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> legalDetails(String medicalLegalNo,ModelMap map) {

        MedicalLegalDetailBO medicalLegalDetailBO = serviceForYouService.detailMedicalLegal(medicalLegalNo);
        return ResponseEntity.ok(ResponseDzz.ok(medicalLegalDetailBO));
    }

}
