package com.dzz.medical.common;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 影响实体
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年06月30 下午1:56
 */
@Data
@XmlRootElement
public class ResponseDzz<T> implements Serializable {

    private static final long serialVersionUID = -5802418480250581704L;

    /**
     * 响应成功编码
     */
    private static final String SUCCESS_CODE = "1";


    /**
     * 标志码1:成功,0:失败
     */
    private String code;


    /**
     * 说明
     */
    private String message;


    /**
     * 数据
     */
    private T data;

    public ResponseDzz() {
        this.code = "1";
        this.message = "success";
        this.data = null;
    }

    public ResponseDzz(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDzz(T data) {
        this.code = "1";
        this.message = "success";
        this.data = data;
    }

    public static ResponseDzz build(String code, String message, Object data) {
        return new ResponseDzz(code, message, data);
    }

    public static ResponseDzz ok(Object data) {
        return new ResponseDzz(data);
    }

    public static ResponseDzz ok() {
        return new ResponseDzz(null);
    }

    public static ResponseDzz build(String code, String message) {
        return new ResponseDzz(code, message, null);
    }

    /**
     * 判断是否成功
     *
     * @return
     */
    public Boolean isSuccess() {
        return SUCCESS_CODE.equals(this.getCode());
    }

}
