package com.dzz.medical.controller.backend_medical_manage.service;

import com.dzz.medical.common.page.PageUtil;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.AddMedicalLegalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalLegalListQueryDTO;

/**
 * 微信前台管理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:09
 */
public interface WxFrontManageService {

    /**
     * 保存法律法规信息
     * @param addLegalDTO 法律法规信息
     * @return 保存结果
     */
    Boolean saveLegal(AddMedicalLegalDTO addLegalDTO);

    /**
     * 法律法规列表查询
     * @param queryDTO 查询条件
     * @return 结果
     */
    PageUtil<MedicalLegalListBO> listMedicalLegal(MedicalLegalListQueryDTO queryDTO);
}
