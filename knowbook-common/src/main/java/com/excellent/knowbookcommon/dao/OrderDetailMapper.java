package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.OrderDetail;
import com.excellent.knowbookcommon.model.pojo.OrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    long countByExample(OrderDetailExample example);

    int deleteByPrimaryKey(@Param("orderId") String orderId, @Param("bookId") String bookId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(@Param("orderId") String orderId, @Param("bookId") String bookId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}