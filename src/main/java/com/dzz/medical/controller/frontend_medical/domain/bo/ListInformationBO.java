package com.dzz.medical.controller.frontend_medical.domain.bo;

import java.io.Serializable;
import lombok.Data;

/**
 * 生知识列表BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月22 下午9:25
 */
@Data
public class ListInformationBO extends ListBaseBO implements Serializable{

    private static final long serialVersionUID = 8228032268481976747L;


    /**
     * 生知识编码
     */
    private String informationNo;

}
