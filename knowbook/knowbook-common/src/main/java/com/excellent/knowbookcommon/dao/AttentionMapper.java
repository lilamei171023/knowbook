package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.Attention;
import com.excellent.knowbookcommon.model.pojo.AttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    long countByExample(AttentionExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("followedUserId") String followedUserId);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionExample example);

    Attention selectByPrimaryKey(@Param("userId") String userId, @Param("followedUserId") String followedUserId);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}