package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.TopicMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.CommentVo;
import com.excellent.knowbookcommon.model.vo.TopicDetails;
import com.excellent.knowbookcommon.model.vo.TopicsVo;
import com.excellent.knowbookcommon.utils.CreateIDUtils;
import com.excellent.knowbookcore.service.CommentService;
import com.excellent.knowbookcore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import com.excellent.knowbookcommon.model.dto.TopicPo;
import com.excellent.knowbookcommon.model.pojo.TopicExample.Criteria;
import com.excellent.knowbookcore.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UsersService usersService;


    private static Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Override
    public List<TopicsVo> selectAllTopics() {
        List<TopicsVo> list=new ArrayList<>();

        TopicExample example=new TopicExample();
        Criteria criteria=example.createCriteria();
        criteria.andDeletedEqualTo(0);
        List<Topic> list1=topicMapper.selectByExample(example);

        for (Topic t:list1) {

            Users users=selectByUserId(t);

            list.add(topicsValues(t, users));
        }
        return list;
    }

    /**
     * 通过topic中的userId查询一条users的信息
     * @param topic
     * @return
     */
    @Override
    public Users selectByUserId(Topic topic) {
        UsersExample example1=new UsersExample();
        UsersExample.Criteria criteria1=example1.createCriteria();
        criteria1.andUserIdEqualTo(topic.getUserId());

        List<Users> usersList=usersMapper.selectByExample(example1);
        return usersList.get(0);
    }

    /**
     * 给TopicsVo对象赋值
     * @param topic
     * @param users
     * @return
     */

    @Override
    public TopicsVo topicsValues(Topic topic, Users users) {
        TopicsVo topicsVo=new TopicsVo();
        topicsVo.setTopicId(topic.getTopicId());
        topicsVo.setTopicName(topic.getTopicName());
        topicsVo.setTopicInfo(topic.getTopicInfo());
        topicsVo.setTopicPicture(topic.getTopicPicture());
        topicsVo.setTopicPraise(topic.getTopicPraise());
        topicsVo.setCreateTime(topic.getCreateTime());
        topicsVo.setUserId(topic.getUserId());

        topicsVo.setUserName(users.getUserName());
        topicsVo.setUserPicture(users.getUserPicture());
        return topicsVo;
    }

    /**
     * 添加一个话题
     * @param topicPo
     * @return
     */

    @Override
    public int addOneTopic(TopicPo topicPo) {
        Topic topic = new Topic();
        topic.setTopicId(CreateIDUtils.CreatId());
        topic.setTopicName(topicPo.getTopicName());
        topic.setTopicInfo(topicPo.getTopicInfo());
        if (topicPo.getTopicPicture() != null) {
            topic.setTopicPicture(topicPo.getTopicPicture());
        }
        topic.setLabel(topicPo.getLabel());
        topic.setUserId(topicPo.getUserId());
        topic.setCreateTime(new Date());
        topic.setCreateUser("Rowena");
        topic.setUpdateUser("Rowena");
        topic.setDeleted(0);
        logger.info("添加一个话题:{}", topic.toString());
        return topicMapper.insertSelective(topic);
    }

    /**
     * 给一个话题点赞
     * @param topicId
     * @return
     */

    @Override
    public int addToTopicPraise(String topicId) {

        TopicExample example=new TopicExample();
        Criteria criteria=example.createCriteria();
        criteria.andDeletedEqualTo(0);
        criteria.andTopicIdEqualTo(topicId);
        Topic record=new Topic();
        int praiseCount=topicMapper.selectByExample(example).get(0).getTopicPraise();
        record.setTopicPraise(praiseCount+1);
        logger.info("当前点赞数为:",praiseCount+1);
        topicMapper.updateByExampleSelective(record,example);
        logger.info("TopicId为{}的话题点赞数加1",topicId);
        return 0;
    }

    /**
     * 查询话题详情
     * @param topicId
     * @return
     */
    @Override
    public TopicDetails TopicDetails(String  topicId) {
        if(topicId==null&&"".equals(topicId)){
            logger.error("topicId输入有误，请检查topicId，并重新操作.");
            return null;
        }else {
            TopicDetails topicDetails=new TopicDetails();
            Topic topic=selectByTopicId(topicId);
            List<CommentVo> commentList=commentService.selectCommentByTopicId(topicId);
            topicDetails.setCommentVoList(commentList);
            topicDetails.setCommentCounts(commentList.size());
            topicDetails=topicDetailsValues(topicDetails,topic);
            return topicDetails;
        }

    }

    /**
     * 通过topicId查询话题
     * @param topicId
     * @return
     */

    public Topic selectByTopicId(String  topicId){
        TopicExample example=new TopicExample();
        Criteria criteria=example.createCriteria();
        criteria.andDeletedEqualTo(0);
        criteria.andTopicIdEqualTo(topicId);
        List<Topic> topicList=topicMapper.selectByExample(example);
        return topicList.get(0);
    }

    /**
     * topicDetails中话题部分的属性赋值
     * @param topicDetails
     * @param topic
     * @return
     */

    public TopicDetails  topicDetailsValues (TopicDetails topicDetails,Topic topic){
         topicDetails.setUserId(topic.getUserId());
         topicDetails.setUserName(usersService.selectUserByUserId(topic.getUserId()).getUserName());
         topicDetails.setTopicName(topic.getTopicName());
         topicDetails.setTopicInfo(topic.getTopicInfo());
         topicDetails.setTopicPicture(topic.getTopicPicture());
         topicDetails.setTopicPraise(topic.getTopicPraise());
         topicDetails.setLabel(topic.getLabel());
         topicDetails.setCreateTime(topic.getCreateTime());

        return topicDetails;
    }


}
