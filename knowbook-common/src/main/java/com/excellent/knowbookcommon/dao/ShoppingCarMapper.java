package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.ShoppingCar;

public interface ShoppingCarMapper {
    int deleteByPrimaryKey(String shoppingCarId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(String shoppingCarId);

    int updateByPrimaryKeySelective(ShoppingCar record);

    int updateByPrimaryKey(ShoppingCar record);
}