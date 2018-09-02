package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.MyCollection;
import com.excellent.knowbookcommon.model.pojo.MyCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyCollectionMapper {
    long countByExample(MyCollectionExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int insert(MyCollection record);

    int insertSelective(MyCollection record);

    List<MyCollection> selectByExample(MyCollectionExample example);

    MyCollection selectByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int updateByExampleSelective(@Param("record") MyCollection record, @Param("example") MyCollectionExample example);

    int updateByExample(@Param("record") MyCollection record, @Param("example") MyCollectionExample example);

    int updateByPrimaryKeySelective(MyCollection record);

    int updateByPrimaryKey(MyCollection record);
}