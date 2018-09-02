package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.*;
import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.UserInterfaceVo;
import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcommon.model.vo.FollowVo;
import com.excellent.knowbookcommon.model.vo.TopicVo;
import com.excellent.knowbookcore.service.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
@Service
public class UserInterfaceServiceImpl implements UserInterfaceService {



    @Autowired
    private SellBookMapper sellBookMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private AttentionMapper attentionMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CommentMapper commentMapper;

    /**根据用户id查找的他的书籍-------------兼容我的书**/
    @Override
    public List<BookVo> queryBookVo(String userId) throws Exception {
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.ERROR);
        }
        SellBookExample example=new SellBookExample();
        SellBookExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<SellBook> sellBookList=sellBookMapper.selectByExample(example);
        List<BookVo> bookVoList=new ArrayList<>();
        for (SellBook sellbook: sellBookList) {
            Book book=bookMapper.selectByPrimaryKey(sellbook.getBookId());
            BookVo bookVo=new BookVo();
            bookVo.setBookId(sellbook.getBookId());
            bookVo.setBookName(book.getBookName());
            bookVo.setBookPicture(book.getBookPicture());
            bookVo.setBookAuthor(book.getBookAuthor());
            bookVo.setBookPress(book.getBookPress());
            bookVo.setCreateTime(book.getCreateTime());
             bookVoList.add(bookVo);
        }

        return bookVoList;
    }
    /**根据用户id查找的他的话题-------兼容我的主题**/
    @Override
    public List<TopicVo> queryTopicVo(String userId) throws Exception {
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.ERROR);
        }
        TopicExample example=new TopicExample();
        TopicExample.Criteria criteria=example.createCriteria();
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria commentcriteria=commentExample.createCriteria();

        criteria.andUserIdEqualTo(userId);
        List<Topic>  topicList=topicMapper.selectByExample(example);
        List<TopicVo> topicVoList=new ArrayList<>();
        for (Topic topic: topicList) {
            TopicVo topicVo=new TopicVo();
            topicVo.setTopicId(topic.getTopicId());
            topicVo.setTopicInfo(topic.getTopicInfo());
            topicVo.setTopicName(topic.getTopicName());
            topicVo.setTopicPraise(topic.getTopicPraise());
            /**寻找一个话题的评论数**/
             List<Comment> commentList=new ArrayList<>();
             commentcriteria=commentcriteria.andTopicIdEqualTo(topic.getUserId());
             commentList=commentMapper.selectByExample(commentExample);
             topicVo.setCommentNumber(commentList.size());
            topicVoList.add(topicVo);
        }
        return topicVoList;
    }

    /**根据用户id查找的他的关注----------兼容我的关注**/
    @Override
    public List<FollowVo> queryfollowVo(String userId) throws Exception {
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.ERROR);
        }
                AttentionExample example=new AttentionExample();
               AttentionExample.Criteria criteria=example.createCriteria();
               criteria.andUserIdEqualTo(userId);
            List<Attention> followIdList=attentionMapper.selectByExample(example);
              List<FollowVo> followVoList=new ArrayList<>();
            UsersExample userexample=new UsersExample();
            UsersExample.Criteria usercriteria=userexample.createCriteria();
        for (Attention attention: followIdList) {
                  usercriteria.andUserIdEqualTo(attention.getUserId());
                  FollowVo followVo=new FollowVo();
                  followVo.setFollowedUserId(attention.getFollowedUserId());
                  followVo.setFolloweuserName(usersMapper.selectByPrimaryKey(attention.getUserId()).getUserName());
                  followVo.setFollowPicture((usersMapper.selectByPrimaryKey(attention.getUserId()).getUserPicture()));
                  followVoList.add(followVo);
        }
         return  followVoList;
    }


    /**根据用户id查找的他的基本信息 名字，头像----------兼容我的信息**/

    @Override
    public UserInterfaceVo queryUserInterfaceVo(String userId) throws Exception {
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.ERROR);
        }
        UsersExample userexample=new UsersExample();
        UsersExample.Criteria usercriteria=userexample.createCriteria();
        usercriteria.andUserIdEqualTo(userId);
        UserInterfaceVo userInterfaceVo=new UserInterfaceVo();
        userInterfaceVo.setUserId(userId);
        userInterfaceVo.setUserPicture(usersMapper.selectByPrimaryKey(userId).getUserPicture());
        userInterfaceVo.setUserName(usersMapper.selectByPrimaryKey(userId).getUserName());

        return  userInterfaceVo;
    }

    @Override
    public Integer insertComment(String userId, String yourselfId) throws Exception {
        if(userId==null||yourselfId==null){
            throw new KownBookException(ResultEnum.ERROR);
        }
        Attention record=new Attention();
        record.setUserId(yourselfId);
        record.setFollowedUserId(userId);
        record.setCreateUser("自己");
        record.setCreateTime(new Date());
        record.setUpdteUser("自己");
        return attentionMapper.insertSelective(record);
    }
}
