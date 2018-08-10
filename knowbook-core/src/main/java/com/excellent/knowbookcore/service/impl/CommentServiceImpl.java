package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.CommentMapper;
import com.excellent.knowbookcommon.model.pojo.Comment;
import com.excellent.knowbookcommon.model.pojo.CommentExample;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.CommentVo;
import com.excellent.knowbookcore.service.CommentService;
import com.excellent.knowbookcore.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UsersService usersService;
    private static Logger logger= LoggerFactory.getLogger(CommentServiceImpl.class);

    /**
     * 添加一条评论
     * @param comment
     * @return
     */
    @Override
    public int addComment(Comment comment) {
        comment.setCreateTime(new Date());
        comment.setDeleted(0);
        comment.setUpdateUser("rowena");
        comment.setCreateUser("rowena");
        if (commentMapper.insertSelective(comment) != 0) {
            return commentMapper.insertSelective(comment);
        } else {
            return 0;
        }
    }

    /**
     * 通过topicId查询对应的评论
     * @param topicId
     * @return
     */
    @Override
    public List<CommentVo> selectCommentByTopicId(String topicId) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(0);
        criteria.andTopicIdEqualTo(topicId);
        List<Comment> commentList = commentMapper.selectByExample(example);
        List<CommentVo> commentVoList=new ArrayList<>();
        for (Comment comment:commentList) {
            CommentVo commentVo=new CommentVo();
            commentVo.setUserId(comment.getUserId());
            commentVo.setCommentInfo(comment.getCommentInfo());
            Users users=usersService.selectUserByUserId(comment.getUserId());
            if(users!=null){
                commentVo.setUserName(users.getUserName());
                commentVo.setUserPicture(users.getUserPicture());
                commentVo.setCreateTime(users.getCreateTime());
//              commentVo.setPraise(comment.getPraise());
            }
            commentVoList.add(commentVo);

        }
        return commentVoList;
    }
}
