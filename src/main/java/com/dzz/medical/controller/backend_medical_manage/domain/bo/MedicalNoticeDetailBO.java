package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import lombok.Data;

/**
 * 通知详情信息
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午10:45
 */
@Data
public class MedicalNoticeDetailBO extends MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = -1461593000044351772L;

    /**
     * 通知编码
     */
    private String noticeNo;


    private String imageServerPath;



    /**
     * 阅读次数
     */
    private Long readCount;
}
