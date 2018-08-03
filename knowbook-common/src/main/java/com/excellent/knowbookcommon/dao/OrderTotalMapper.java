package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.OrderTotal;

public interface OrderTotalMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderTotal record);

    int insertSelective(OrderTotal record);

    OrderTotal selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderTotal record);

    int updateByPrimaryKey(OrderTotal record);
}