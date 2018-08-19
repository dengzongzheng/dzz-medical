package com.dzz.medical.controller.backend_medical_manage.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalInformationDTO;

/**
 * 微信前台管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:09
 */
public interface WxFrontInformationManageService {

    /**
     * 保存卫生知识信息
     * @param addInformationDTO 卫生知识信息
     * @return 保存结果
     */
    Boolean saveInformation(AddMedicalDTO addInformationDTO);

    /**
     * 卫生知识列表查询
     * @param queryDTO 查询条件
     * @return 结果
     */
    PageUtil<MedicalInformationListBO> listMedicalInformation(MedicalListQueryDTO queryDTO);


    /**
     * 更新卫生知识状态
     * @param medicalInformationNo 卫生知识代码
     * @param status 状态
     * @return 更新结果
     */
    Boolean updateStatus(String medicalInformationNo, Integer status);


    /**
     * 更新卫生知识信息
     * @param updateMedicalInformationDTO 参数
     * @return 更新结果
     */
    Boolean updateMedicalInformation(UpdateMedicalInformationDTO updateMedicalInformationDTO);


    /**
     * 卫生知识详情
     * @param medicalInformationNo 卫生知识号
     * @return 详情
     */
    MedicalInformationDetailBO detailMedicalInformation(String medicalInformationNo);
}
