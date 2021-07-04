package com.excellent.knowbookcommon.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "topicindex", type = "topic")
public class Topic implements Serializable {
    //    @Id
    private String topicId;

    private Integer id;
    //   @Field
    private String topicName;
    //  @Field
    private String topicInfo;
    //   @Field
    private String topicPicture;
    //  @Field
    private Integer topicPraise;
    //   @Field
    private String userId;
    //   @Field
    private Date createTime;
    //  @Field
    private String createUser;
    //   @Field
    private Date updateTime;
    //   @Field
    private String updateUser;
    //   @Field
    private Integer deleted;
    //  @Field
    private String label;

    private static final long serialVersionUID = 1L;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicInfo() {
        return topicInfo;
    }

    public void setTopicInfo(String topicInfo) {
        this.topicInfo = topicInfo;
    }

    public String getTopicPicture() {
        return topicPicture;
    }

    public void setTopicPicture(String topicPicture) {
        this.topicPicture = topicPicture;
    }

    public Integer getTopicPraise() {
        return topicPraise;
    }

    public void setTopicPraise(Integer topicPraise) {
        this.topicPraise = topicPraise;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}