package com.dzz.medical.controller.backend_medical_manage.dao;

import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalLegalListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalLegalDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalLegal;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListLegalBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListLegalQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
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
    List<MedicalLegalListBO> listMedicalLegal(MedicalListQueryDTO param);


    /**
     * 法律法规列表查询，用于前台展示
     * @param param 查询条件
     * @return 结果
     */
    List<ListLegalBO> listLegal(ListLegalQueryDTO param);


    /**
     * 更新法律法规状态
     * @param medicalLegalNo 法律法规号
     * @param status 状态
     * @see com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.LegalStatusEnums
     * @return 更新条数
     */
    Integer updateStatus(@Param("medicalLegalNo") String medicalLegalNo,@Param("status") Integer status);

    /**
     * 更新法律法规信息
     * @param updateMedicalLegalDTO 法律法规信息
     * @return 更新条数
     */
    Integer updateMedicalLegal(@Param("param") UpdateMedicalLegalDTO updateMedicalLegalDTO);

    /**
     * 法律法规详情
     * @param medicalLegalNo 法律法规号
     * @return 结果
     */
    MedicalLegalDetailBO detailMedicalLegal(@Param("medicalLegalNo") String medicalLegalNo);

}