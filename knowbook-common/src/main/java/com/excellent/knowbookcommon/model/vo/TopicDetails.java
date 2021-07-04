package com.excellent.knowbookcommon.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/9
 * Description:
 */
@Data
public class TopicDetails {

    private String userId;

    private String label;

    private String userName;

    private String topicName;

    private String topicInfo;

    private String topicPicture;

    private Integer topicPraise;

    private  Date    createTime;

    private  int  CommentCounts;

    private List<CommentVo> commentVoList;
}
