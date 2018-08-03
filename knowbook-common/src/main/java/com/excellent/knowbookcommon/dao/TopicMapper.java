package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.Topic;

public interface TopicMapper {
    int deleteByPrimaryKey(String topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(String topicId);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);
}