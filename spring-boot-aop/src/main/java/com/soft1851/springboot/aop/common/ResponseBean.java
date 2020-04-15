package com.soft1851.springboot.aop.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ResponseBean
 * @Description 返回给客户端的结果对象
 * @Version 1.0
 **/
@Data
public class ResponseBean implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

    private ResponseBean() {
    }

    public ResponseBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseBean success() {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResultCode(ResultCode.SUCCESS);
        return responseBean;
    }

    public static ResponseBean success(Object data) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResultCode(ResultCode.SUCCESS);
        responseBean.setData(data);
        return responseBean;
    }

    public static ResponseBean failure(ResultCode resultCode) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResultCode(resultCode);
        return responseBean;
    }

    public static ResponseBean failure(ResultCode resultCode, Object data) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResultCode(resultCode);
        responseBean.setData(data);
        return responseBean;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
}