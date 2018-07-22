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
public class AddMedicalLegalDTO implements Serializable{

    private static final long serialVersionUID = -610545921277352373L;

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
     * 法律法规内容
     */
    @Column(name = "text_data")
    private String textData;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改者
     */
    private String updator;
}
