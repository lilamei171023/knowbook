package com.excellent.knowbookcommon.model.enums;

/**
 * @User: Rowena
 * @Date: 2018/8/1
 * Description:
 */
public enum ResultEnum {
    FAIL(101,"fail"),
    SUCCESS(200,"success"),
    ERROR(102,"error"),
    UknError(103,"UnKnownError"),
    UIDEQUALNULL(104,"userId为空");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
