package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.SellBook;
import org.apache.ibatis.annotations.Param;

public interface SellBookMapper {
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int insert(SellBook record);

    int insertSelective(SellBook record);

    SellBook selectByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int updateByPrimaryKeySelective(SellBook record);

    int updateByPrimaryKey(SellBook record);
}