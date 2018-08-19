package com.dzz.medical.controller.frontend_medical.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListInformationBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListNoticeBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListWorkNewsBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;

/**
 * 为您服务接口定义
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午6:42
 */
public interface MedicalBroadcastService {

    /**
     * 通知列表查询
     * @param query 查询条件
     * @return 结果
     */
    PageUtil<ListNoticeBO> listNotice(ListQueryDTO query);


    /**
     * 通知详情
     * @param medicalNoticeNo 通知号
     * @return 详情
     */
    MedicalNoticeDetailBO detailMedicalNotice(String medicalNoticeNo);



    /**
     * 卫生知识列表查询
     * @param query 查询条件
     * @return 结果
     */
    PageUtil<ListInformationBO> listInformation(ListQueryDTO query);


    /**
     * 卫生知识详情
     * @param medicalInformationNo 卫生知识号
     * @return 详情
     */
    MedicalInformationDetailBO detailMedicalInformation(String medicalInformationNo);


    /**
     * 工作动态列表查询
     * @param query 查询条件
     * @return 结果
     */
    PageUtil<ListWorkNewsBO> listWorkNews(ListQueryDTO query);


    /**
     * 工作动态详情
     * @param medicalWorkNewsNo 工作动态号
     * @return 详情
     */
    MedicalWorkNewsDetailBO detailMedicalWorkNews(String medicalWorkNewsNo);
}