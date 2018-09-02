package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.SellBook;
import com.excellent.knowbookcommon.model.pojo.SellBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellBookMapper {
    long countByExample(SellBookExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int insert(SellBook record);

    int insertSelective(SellBook record);

    List<SellBook> selectByExample(SellBookExample example);

    SellBook selectByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    int updateByExampleSelective(@Param("record") SellBook record, @Param("example") SellBookExample example);

    int updateByExample(@Param("record") SellBook record, @Param("example") SellBookExample example);

    int updateByPrimaryKeySelective(SellBook record);

    int updateByPrimaryKey(SellBook record);
}