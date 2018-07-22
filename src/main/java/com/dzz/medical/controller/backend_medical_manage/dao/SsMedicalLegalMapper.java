package com.dzz.medical.controller.backend_medical_manage.dao;

import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalLegalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalLegal;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 法律法规Mapper
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月20 上午7:39
 */
public interface SsMedicalLegalMapper extends Mapper<SsMedicalLegal> {

    /**
     * 列表查询
     * @param param 参数
     * @return 结果
     */
    List<MedicalLegalListBO> listMedicalLegal(MedicalLegalListQueryDTO param);

}