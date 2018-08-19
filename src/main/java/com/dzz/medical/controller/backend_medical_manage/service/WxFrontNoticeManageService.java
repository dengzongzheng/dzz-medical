package com.dzz.medical.controller.backend_medical_manage.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalNoticeDTO;

/**
 * 微信前台管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:09
 */
public interface WxFrontNoticeManageService {

    /**
     * 保存通知信息
     * @param addNoticeDTO 通知信息
     * @return 保存结果
     */
    Boolean saveNotice(AddMedicalDTO addNoticeDTO);

    /**
     * 通知列表查询
     * @param queryDTO 查询条件
     * @return 结果
     */
    PageUtil<MedicalNoticeListBO> listMedicalNotice(MedicalListQueryDTO queryDTO);


    /**
     * 更新通知状态
     * @param medicalNoticeNo 通知代码
     * @param status 状态
     * @return 更新结果
     */
    Boolean updateStatus(String medicalNoticeNo, Integer status);


    /**
     * 更新通知信息
     * @param updateMedicalNoticeDTO 参数
     * @return 更新结果
     */
    Boolean updateMedicalNotice(UpdateMedicalNoticeDTO updateMedicalNoticeDTO);


    /**
     * 通知详情
     * @param medicalNoticeNo 通知号
     * @return 详情
     */
    MedicalNoticeDetailBO detailMedicalNotice(String medicalNoticeNo);
}
