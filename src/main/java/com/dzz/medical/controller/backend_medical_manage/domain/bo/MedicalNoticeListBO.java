package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import lombok.Data;

/**
 * 通知列表BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:25
 */
@Data
public class MedicalNoticeListBO extends MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = 8228032268481976747L;


    /**
     * 通知编码
     */
    private String noticeNo;

}
