package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import lombok.Data;

/**
 * 工作动态列表BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:25
 */
@Data
public class MedicalWorkNewsListBO extends MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = 8228032268481976747L;


    /**
     * 工作动态编码
     */
    private String workNewsNo;

}
