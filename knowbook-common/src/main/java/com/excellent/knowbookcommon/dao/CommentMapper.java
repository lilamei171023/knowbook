package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String commmentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String commmentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}