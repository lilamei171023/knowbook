package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.pojo.Comment;
import com.excellent.knowbookcommon.model.vo.CommentVo;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
public interface CommentService {

    int addComment(Comment comment);

    List<CommentVo> selectCommentByTopicId(String TopicId);
}
