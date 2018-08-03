package com.excellent.knowbookcommon.model.exception;

import com.excellent.knowbookcommon.model.enums.ResultEnum;

/**
 * @User: Rowena
 * @Date: 2018/8/1
 * Description:
 */
public class KownBookException  extends RuntimeException {
    private Integer code;
    public KownBookException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
