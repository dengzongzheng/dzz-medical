package com.dzz.medical.controller.backend_medical_manage.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalWorkNewsDTO;

/**
 * 微信前台管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:09
 */
public interface WxFrontWorkNewsManageService {

    /**
     * 保存工作动态信息
     * @param addWorkNewsDTO 工作动态信息
     * @return 保存结果
     */
    Boolean saveWorkNews(AddMedicalDTO addWorkNewsDTO);

    /**
     * 工作动态列表查询
     * @param queryDTO 查询条件
     * @return 结果
     */
    PageUtil<MedicalWorkNewsListBO> listMedicalWorkNews(MedicalListQueryDTO queryDTO);


    /**
     * 更新工作动态状态
     * @param medicalWorkNewsNo 工作动态代码
     * @param status 状态
     * @return 更新结果
     */
    Boolean updateStatus(String medicalWorkNewsNo, Integer status);


    /**
     * 更新工作动态信息
     * @param updateMedicalWorkNewsDTO 参数
     * @return 更新结果
     */
    Boolean updateMedicalWorkNews(UpdateMedicalWorkNewsDTO updateMedicalWorkNewsDTO);


    /**
     * 工作动态详情
     * @param medicalWorkNewsNo 工作动态号
     * @return 详情
     */
    MedicalWorkNewsDetailBO detailMedicalWorkNews(String medicalWorkNewsNo);
}
