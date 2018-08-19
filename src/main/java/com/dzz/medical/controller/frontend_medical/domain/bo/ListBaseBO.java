package com.dzz.medical.controller.frontend_medical.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import lombok.Data;

/**
 * 基础BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月19 上午7:22
 */
@Data
public class ListBaseBO implements Serializable{

    private static final long serialVersionUID = -1990152080244537102L;

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


    /**
     * 阅读次数
     */
    private Long readCount;


    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
}
