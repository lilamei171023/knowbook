package com.excellent.knowbookcommon.model.vo;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
public class TopicVo {
    /**话题**/
    private  String topicId;
    private String topicInfo;
    private String topicName;
    private Integer topicPraise;
    private Integer commentNumber ;

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Integer getTopicPraise() {
        return topicPraise;
    }

    public void setTopicPraise(Integer topicPraise) {
        this.topicPraise = topicPraise;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicInfo() {
        return topicInfo;
    }

    public void setTopicInfo(String topicInfo) {
        this.topicInfo = topicInfo;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
