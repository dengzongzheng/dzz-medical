package com.dzz.medical.controller.backend_medical_manage.dao;

import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalInformationListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalInformationDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalInformation;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListInformationBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * 卫生知识Mapper
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月20 上午7:39
 */
public interface SsMedicalInformationMapper extends Mapper<SsMedicalInformation> {

    /**
     * 列表查询
     * @param param 参数
     * @return 结果
     */
    List<MedicalInformationListBO> listMedicalInformation(MedicalListQueryDTO param);


    /**
     * 卫生知识列表查询，用于前台展示
     * @param param 查询条件
     * @return 结果
     */
    List<ListInformationBO> listInformation(ListQueryDTO param);


    /**
     * 更新卫生知识状态
     * @param medicalInformationNo 卫生知识号
     * @param status 状态
     * @see com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.LegalStatusEnums
     * @return 更新条数
     */
    Integer updateStatus(@Param("medicalInformationNo") String medicalInformationNo,@Param("status") Integer status);

    /**
     * 更新卫生知识信息
     * @param updateMedicalInformationDTO 卫生知识信息
     * @return 更新条数
     */
    Integer updateMedicalInformation(@Param("param") UpdateMedicalInformationDTO updateMedicalInformationDTO);

    /**
     * 卫生知识详情
     * @param medicalInformationNo 卫生知识号
     * @return 结果
     */
    MedicalInformationDetailBO detailMedicalInformation(@Param("medicalInformationNo") String medicalInformationNo);
}