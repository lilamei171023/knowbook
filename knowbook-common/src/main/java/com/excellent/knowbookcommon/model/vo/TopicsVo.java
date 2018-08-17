package com.excellent.knowbookcommon.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @User: Rowena
 * @Date: 2018/8/9
 * Description:
 */
@Data
public class TopicsVo {

    private String topicId;

    private String topicName;

    private String topicInfo;

    private String topicPicture;

    private Integer topicPraise;

    private String userId;

    private Date createTime;

    private String userName;

    private String userPicture;

}
