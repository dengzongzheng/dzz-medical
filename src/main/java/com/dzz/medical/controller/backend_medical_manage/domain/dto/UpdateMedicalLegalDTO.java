package com.dzz.medical.controller.backend_medical_manage.domain.dto;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.Data;

/**
 * 法律法规新DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午8:17
 */
@Data
public class UpdateMedicalLegalDTO extends AddMedicalLegalDTO implements Serializable{


    private static final long serialVersionUID = 7435461661864996364L;

    /**
     * 法律法规编码
     */
    @Column(name = "medical_legal_no")
    private String medicalLegalNo;
}
