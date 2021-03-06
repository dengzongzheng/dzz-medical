package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.Data;

/**
 * 法律法规列表BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:25
 */
@Data
public class MedicalLegalListBO extends MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = 8228032268481976747L;


    /**
     * 法律法规编码
     */
    @Column(name = "medical_legal_no")
    private String medicalLegalNo;

}
