package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.Data;

/**
 * 法律法规详情信息
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午10:45
 */
@Data
public class MedicalLegalDetailBO extends MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = -1461593000044351772L;



    /**
     * 法律法规编码
     */
    @Column(name = "medical_legal_no")
    private String medicalLegalNo;


    private String imageServerPath;



    /**
     * 阅读次数
     */
    private Long readCount;
}
