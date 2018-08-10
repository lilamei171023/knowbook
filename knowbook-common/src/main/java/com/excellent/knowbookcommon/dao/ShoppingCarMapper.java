package com.excellent.knowbookcommon.dao;

import com.excellent.knowbookcommon.model.pojo.ShoppingCar;
import com.excellent.knowbookcommon.model.pojo.ShoppingCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingCarMapper {
    long countByExample(ShoppingCarExample example);

    int deleteByPrimaryKey(String shoppingCarId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    List<ShoppingCar> selectByExample(ShoppingCarExample example);

    ShoppingCar selectByPrimaryKey(String shoppingCarId);

    int updateByExampleSelective(@Param("record") ShoppingCar record, @Param("example") ShoppingCarExample example);

    int updateByExample(@Param("record") ShoppingCar record, @Param("example") ShoppingCarExample example);

    int updateByPrimaryKeySelective(ShoppingCar record);

    int updateByPrimaryKey(ShoppingCar record);
}