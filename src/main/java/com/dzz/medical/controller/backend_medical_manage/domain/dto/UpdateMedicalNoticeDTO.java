package com.dzz.medical.controller.backend_medical_manage.domain.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 通知新DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午8:17
 */
@Data
public class UpdateMedicalNoticeDTO extends AddMedicalDTO implements Serializable{


    private static final long serialVersionUID = 7435461661864996364L;

    private String id;

    /**
     * 通知编码
     */
    private String medicalNoticeNo;
}
