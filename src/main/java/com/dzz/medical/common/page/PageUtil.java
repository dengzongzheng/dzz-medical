package com.dzz.medical.common.page;


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

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof PageUtil)) {
            return false;
        } else {
            PageUtil<?> other = (PageUtil)o;
            if(!other.canEqual(this)) {
                return false;
            } else if(this.getPageNo() != other.getPageNo()) {
                return false;
            } else if(this.getTotalCount() != other.getTotalCount()) {
                return false;
            } else if(this.getTotalPage() != other.getTotalPage()) {
                return false;
            } else if(this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if(this$data == null) {
                    if(other$data != null) {
                        return false;
                    }
                } else if(!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageUtil;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getPageNo();
        long $totalCount = this.getTotalCount();
        result = result * 59 + (int)($totalCount >>> 32 ^ $totalCount);
        result = result * 59 + this.getTotalPage();
        result = result * 59 + this.getPageSize();
        Object $data = this.getData();
        result = result * 59 + ($data == null?43:$data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PageUtil(pageNo=" + this.getPageNo() + ", totalCount=" + this.getTotalCount() + ", totalPage=" + this.getTotalPage() + ", pageSize=" + this.getPageSize() + ", data=" + this.getData() + ")";
    }
}
