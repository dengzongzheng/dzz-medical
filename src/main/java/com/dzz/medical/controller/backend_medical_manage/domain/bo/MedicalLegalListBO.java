package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import java.util.Date;
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
public class MedicalLegalListBO implements Serializable{

    private static final long serialVersionUID = 8228032268481976747L;

    private Long id;

    /**
     * 法律法规编码
     */
    @Column(name = "medical_legal_no")
    private String medicalLegalNo;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 标题图片
     */
    @Column(name = "title_images")
    private String titleImages;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 置顶
     */
    private Integer toping;

    /**
     * 状态：1:正常、2:下线、0:配置中
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
