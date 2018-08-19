package com.dzz.medical.controller.frontend_medical.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListLegalBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;

/**
 * 为您服务接口定义
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午6:42
 */
public interface ServiceForYouService {

    /**
     * 法律法规列表查询
     * @param query 查询条件
     * @return 结果
     */
    PageUtil<ListLegalBO> listLegal(ListQueryDTO query);


    /**
     * 法律法规详情
     * @param medicalLegalNo 法律法规号
     * @return 详情
     */
    MedicalLegalDetailBO detailMedicalLegal(String medicalLegalNo);
}