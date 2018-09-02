package com.excellent.knowbookcommon.model.vo;

import lombok.Data;

/**
 * @User: Rowena
 * @Date: 2018/7/31
 * Description:
 */
@Data
public class UsersVo {
    private String userName;
    private String userNumber;
    private String userPhone;
    private Double wallet;

    @Override
    public String toString() {
        return "UsersVo{" +
                "user_name='" + userName + '\'' +
                ", user_number='" + userNumber + '\'' +
                ", user_phone='" + userPhone + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
