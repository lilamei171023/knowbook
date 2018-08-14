package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.dto.TopicPo;
import com.excellent.knowbookcommon.model.pojo.Comment;
import com.excellent.knowbookcommon.model.pojo.Topic;
import com.excellent.knowbookcommon.model.pojo.TopicExample;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.TopicDetails;
import com.excellent.knowbookcommon.model.vo.TopicsVo;

import java.util.List;
import java.util.Map;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
public interface TopicService {

     List<TopicsVo> selectAllTopics();

     int addOneTopic(TopicPo topicPo);

     int addToTopicPraise(String topicId);

     Users selectByUserId(Topic topic);

     TopicsVo  topicsValues(Topic topic,Users users);

     TopicDetails TopicDetails(String topicId);

     String  saveTopic(Topic topic);

     List<Topic> searchTopic(Integer pageNumber,
                             Integer pageSize,
                             String searchContent);

     List<Topic> selectAllTopic();

}
