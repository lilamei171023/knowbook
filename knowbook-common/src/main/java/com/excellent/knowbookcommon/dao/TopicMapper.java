package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.Topic;
import com.excellent.knowbookcommon.model.pojo.TopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper {
    long countByExample(TopicExample example);

    int deleteByPrimaryKey(String topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    List<Topic> selectByExampleWithBLOBs(TopicExample example);

    List<Topic> selectByExample(TopicExample example);

    Topic selectByPrimaryKey(String topicId);

    int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExampleWithBLOBs(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);
}