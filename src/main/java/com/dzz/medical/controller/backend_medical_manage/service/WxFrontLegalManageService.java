package com.dzz.medical.controller.backend_medical_manage.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalLegalDTO;

/**
 * 微信前台管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:09
 */
public interface WxFrontLegalManageService {

    /**
     * 保存法律法规信息
     * @param addLegalDTO 法律法规信息
     * @return 保存结果
     */
    Boolean saveLegal(AddMedicalDTO addLegalDTO);

    /**
     * 法律法规列表查询
     * @param queryDTO 查询条件
     * @return 结果
     */
    PageUtil<MedicalLegalListBO> listMedicalLegal(MedicalListQueryDTO queryDTO);


    /**
     * 更新法律法规状态
     * @param medicalLegalNo 法律法规代码
     * @param status 状态
     * @return 更新结果
     */
    Boolean updateStatus(String medicalLegalNo, Integer status);


    /**
     * 更新法律法规信息
     * @param updateMedicalLegalDTO 参数
     * @return 更新结果
     */
    Boolean updateMedicalLegal(UpdateMedicalLegalDTO updateMedicalLegalDTO);


    /**
     * 法律法规详情
     * @param medicalLegalNo 法律法规号
     * @return 详情
     */
    MedicalLegalDetailBO detailMedicalLegal(String medicalLegalNo);
}
