package com.dzz.medical.controller.frontend_medical.domain.bo;

import java.io.Serializable;
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
public class ListLegalBO extends ListBaseBO implements Serializable{

    private static final long serialVersionUID = 5457149343767211432L;

    /**
     * 法律法规编码
     */
    @Column(name = "medical_legal_no")
    private String medicalLegalNo;

}
