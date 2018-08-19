package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import lombok.Data;

/**
 * 工作动态详情信息
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午10:45
 */
@Data
public class MedicalWorkNewsDetailBO extends MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = -1461593000044351772L;



    /**
     * 工作动态编码
     */
    private String workNewsNo;


    private String imageServerPath;



    /**
     * 阅读次数
     */
    private Long readCount;
}
