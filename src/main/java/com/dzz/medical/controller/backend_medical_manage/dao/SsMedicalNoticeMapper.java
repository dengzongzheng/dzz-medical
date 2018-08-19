package com.dzz.medical.controller.backend_medical_manage.dao;

import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeDetailBO;
import com.dzz.medical.controller.backend_medical_manage.domain.bo.MedicalNoticeListBO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.MedicalListQueryDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.dto.UpdateMedicalNoticeDTO;
import com.dzz.medical.controller.backend_medical_manage.domain.model.SsMedicalNotice;
import com.dzz.medical.controller.frontend_medical.domain.bo.ListNoticeBO;
import com.dzz.medical.controller.frontend_medical.domain.dto.ListLegalQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * 通知Mapper
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月20 上午7:39
 */
public interface SsMedicalNoticeMapper extends Mapper<SsMedicalNotice> {

    /**
     * 列表查询
     * @param param 参数
     * @return 结果
     */
    List<MedicalNoticeListBO> listMedicalNotice(MedicalListQueryDTO param);


    /**
     * 通知列表查询，用于前台展示
     * @param param 查询条件
     * @return 结果
     */
    List<ListNoticeBO> listNotice(ListLegalQueryDTO param);


    /**
     * 更新通知状态
     * @param medicalNoticeNo 通知号
     * @param status 状态
     * @see com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MedicalStatusEnums
     * @return 更新条数
     */
    Integer updateStatus(@Param("medicalNoticeNo") String medicalNoticeNo,@Param("status") Integer status);

    /**
     * 更新通知信息
     * @param updateMedicalNoticeDTO 通知信息
     * @return 更新条数
     */
    Integer updateMedicalNotice(@Param("param") UpdateMedicalNoticeDTO updateMedicalNoticeDTO);

    /**
     * 通知详情
     * @param medicalNoticeNo 通知号
     * @return 结果
     */
    MedicalNoticeDetailBO detailMedicalNotice(@Param("medicalNoticeNo") String medicalNoticeNo);
}