package com.dzz.medical.controller.backend_medical_manage.domain.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;


/**
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午2:15
 */
@Table(name = "ss_medical_notice")
@Data
public class SsMedicalNotice {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 通知编码
     */
    @Column(name = "notice_no")
    private String noticeNo;

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
    private Integer topping;

    /**
     * 状态：1:正常、2:下线、0:配置中
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 修改者
     */
    private String updater;

    /**
     * 内容
     */
    @Column(name = "text_data")
    private String textData;

    /**
     * 创建实例
     * @return 结果
     */
    public static SsMedicalNotice newInstance() {

        SsMedicalNotice ssMedicalNotice = new SsMedicalNotice();
        ssMedicalNotice.setStatus(1);
        ssMedicalNotice.setCreateTime(new Date());
        ssMedicalNotice.setUpdateTime(ssMedicalNotice.getCreateTime());
        return ssMedicalNotice;
    }
}