package com.dzz.medical.controller.frontend_medical.domain.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 法律法规列表查询
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月28 下午6:21
 */
@Data
public class ListLegalQueryDTO implements Serializable{

    private static final long serialVersionUID = -2116407564310929671L;

    private Integer pageNo;

    private Integer pageSize;

    private Boolean needPage;
}
