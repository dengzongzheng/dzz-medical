package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import java.io.Serializable;
import java.util.List;
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
public class MedicalLegalDetailBO implements Serializable{

    private static final long serialVersionUID = -1461593000044351772L;


    private String id;


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


    private String imageServerPath;

    /**
     * 标题图片列表
     */
    private List<String> listTitleImage;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 置顶
     */
    private Integer topping;


    /**
     * 法律法规内容
     */
    @Column(name = "text_data")
    private String textData;
}
