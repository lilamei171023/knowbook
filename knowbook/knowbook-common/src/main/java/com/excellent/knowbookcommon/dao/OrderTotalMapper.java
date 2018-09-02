package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.OrderTotal;
import com.excellent.knowbookcommon.model.pojo.OrderTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTotalMapper {
    long countByExample(OrderTotalExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderTotal record);

    int insertSelective(OrderTotal record);

    List<OrderTotal> selectByExample(OrderTotalExample example);

    OrderTotal selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderTotal record, @Param("example") OrderTotalExample example);

    int updateByExample(@Param("record") OrderTotal record, @Param("example") OrderTotalExample example);

    int updateByPrimaryKeySelective(OrderTotal record);

    int updateByPrimaryKey(OrderTotal record);
}