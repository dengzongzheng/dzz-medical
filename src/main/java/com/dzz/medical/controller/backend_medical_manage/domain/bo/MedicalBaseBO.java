package com.dzz.medical.controller.backend_medical_manage.domain.bo;

import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.MedicalStatusEnums;
import com.dzz.medical.controller.backend_medical_manage.common.enums.WxManageEnums.ToppingEnums;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import lombok.Data;

/**
 * 基础BO信息
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年08月19 上午7:03
 */
@Data
public class MedicalBaseBO implements Serializable{

    private static final long serialVersionUID = -1186094173059357964L;

    private Long id;


    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    private List<String> listTitleImage;

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


    private String toppingName;

    /**
     * 状态：1:正常、2:下线、0:配置中
     */
    private Integer status;


    private String statusName;

    /**
     * 法律法规内容
     */
    @Column(name = "text_data")
    private String textData;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 是否置顶转换
     * @return 结果
     */
    public String getToppingName() {

        if (Objects.nonNull(this.topping)) {
            return ToppingEnums.getNameByCode(topping);
        }
        return "";
    }

    /**
     * 状态转换
     * @return 结果
     */
    public String getStatusName() {

        if (Objects.nonNull(status)) {
            return MedicalStatusEnums.getNameByCode(status);
        }
        return "";
    }
}
