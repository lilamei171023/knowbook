package com.excellent.knowbookcommon.model.vo;

/**
 * @User: Rowena
 * @Date: 2018/7/31
 * Description: 返回给前端统一用ResultVo类型
 */
public class ResultVo<T>{
    private Integer code;
    private String  msg;
    private  T  data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
