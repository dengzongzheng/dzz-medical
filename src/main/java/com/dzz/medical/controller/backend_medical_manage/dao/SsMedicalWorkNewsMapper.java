package com.dzz.medical.controller.backend_medical_manage.dao;

import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalWorkNewsListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalWorkNewsDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalWorkNews;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListWorkNewsBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * 工作动态Mapper
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月20 上午7:39
 */
public interface SsMedicalWorkNewsMapper extends Mapper<SsMedicalWorkNews> {

    /**
     * 列表查询
     * @param param 参数
     * @return 结果
     */
    List<MedicalWorkNewsListBO> listMedicalWorkNews(MedicalListQueryDTO param);


    /**
     * 工作动态列表查询，用于前台展示
     * @param param 查询条件
     * @return 结果
     */
    List<ListWorkNewsBO> listWorkNews(ListQueryDTO param);


    /**
     * 更新工作动态状态
     * @param medicalWorkNewsNo 工作动态号
     * @param status 状态
     * @see com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.LegalStatusEnums
     * @return 更新条数
     */
    Integer updateStatus(@Param("medicalWorkNewsNo") String medicalWorkNewsNo,@Param("status") Integer status);

    /**
     * 更新工作动态信息
     * @param updateMedicalWorkNewsDTO 工作动态信息
     * @return 更新条数
     */
    Integer updateMedicalWorkNews(@Param("param") UpdateMedicalWorkNewsDTO updateMedicalWorkNewsDTO);

    /**
     * 工作动态详情
     * @param medicalWorkNewsNo 工作动态号
     * @return 结果
     */
    MedicalWorkNewsDetailBO detailMedicalWorkNews(@Param("medicalWorkNewsNo") String medicalWorkNewsNo);
}