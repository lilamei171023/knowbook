package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.Attention;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("followedUserId") String followedUserId);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(@Param("userId") String userId, @Param("followedUserId") String followedUserId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}