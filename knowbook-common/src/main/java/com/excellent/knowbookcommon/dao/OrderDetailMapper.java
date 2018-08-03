package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(@Param("orderId") String orderId, @Param("bookId") String bookId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(@Param("orderId") String orderId, @Param("bookId") String bookId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}