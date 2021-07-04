package com.excellent.knowbookcommon.model.vo;

import com.excellent.knowbookcommon.model.pojo.Comment;
import com.excellent.knowbookcommon.model.pojo.Topic;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
