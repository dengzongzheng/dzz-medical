package com.dzz.medical.controller.backend_medical_manage.domain.dto;

import io.swagger.annotations.ApiParam;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import lombok.Data;

/**
 * 法律法规列表查询DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:36
 */
@Data
public class MedicalLegalListQueryDTO implements Serializable{

    private static final long serialVersionUID = 3518190252637403544L;

    /**
     * 标题
     */
    private String title;


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

    @ApiParam(name = "pageNo",value = "当前页",required = true)
    private int pageNo;


    @ApiParam(name = "pageSize",value = "每页条数",required = true)
    private int pageSize;
}
