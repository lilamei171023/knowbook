package com.excellent.knowbookcommon.model.pojo;

import java.io.Serializable;
import java.util.Date;

public class Attention implements Serializable {
    private String userId;

    private String followedUserId;

    private Integer id;

    private String createUser;

    private Date createTime;

    private Date updateTime;

    private String updteUser;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(String followedUserId) {
        this.followedUserId = followedUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdteUser() {
        return updteUser;
    }

    public void setUpdteUser(String updteUser) {
        this.updteUser = updteUser;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}