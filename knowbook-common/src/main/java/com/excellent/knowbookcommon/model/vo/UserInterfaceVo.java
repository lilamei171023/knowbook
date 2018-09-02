package com.excellent.knowbookcommon.model.vo;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
public class UserInterfaceVo {
    private   String userId;
    private  String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private  String userPicture;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String user_picture) {
        this.userPicture = user_picture;
    }
}
