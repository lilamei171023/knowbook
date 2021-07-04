package com.excellent.knowbookcommon.model.dto;

import lombok.Data;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
@Data
public class TopicPo {
    private String topicName;
    private String topicInfo;
    private String topicPicture;
    private String label;
    private String userId;
}
