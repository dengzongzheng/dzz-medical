package com.dzz.medical.common;


import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 分页数据
 *
 * @author syf
 * @version 1.0.0
 * @since 2016年08月27 下午6:39
 */
@Data
@XmlRootElement
public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = 8095645919885118217L;

    @ApiModelProperty(value = "当前页", required = true)
    private int pageNo = 1;

    @ApiModelProperty(value = "总条数", required = true)
    private long totalCount;

    @ApiModelProperty(value = "总页数", required = true)
    private int totalPage;

    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize = 10;

    @ApiModelProperty(value = "数据", required = true)
    private List<T> data;

    /**
     * 计算一共多少页
     */
    public void setTotalPage() {
        if (this.totalCount == 0) {
            this.totalPage = 0;
        } else {
            this.totalPage =
                    (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
                            : this.totalCount / this.pageSize);
        }
    }
}
