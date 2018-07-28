package com.dzz.medical.controller.frontend_medical.domain.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import lombok.Data;

/**
 * 法律法规列表实体
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午6:44
 */
@Data
public class ListLegalBO implements Serializable{

    private static final long serialVersionUID = 5457149343767211432L;

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
     * 是否只含有一张图
     */
    private Boolean isOneImage;

    /**
     * 一张图
     */
    private String oneTitleImage;

    /**
     * 图片服务器地址
     */
    private String imageServerPath;

    /**
     * 标题图片列表
     */
    private List<String> listTitleImage;


}
