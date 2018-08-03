package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.MyCollection;
import org.apache.ibatis.annotations.Param;

public interface MyCollectionMapper {
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int insert(MyCollection record);

    int insertSelective(MyCollection record);

    MyCollection selectByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int updateByPrimaryKeySelective(MyCollection record);

    int updateByPrimaryKey(MyCollection record);
}