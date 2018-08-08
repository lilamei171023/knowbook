package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.pojo.Address;
import com.excellent.knowbookcommon.model.vo.AddressTotal;
import com.excellent.knowbookcommon.model.vo.PurchasePage;

import java.util.List;

/**
 * 购买逻辑层
 */
public interface PurchaseService {

    PurchasePage queryPurchase(String userId,String bookId);

    List<AddressTotal> queryAddressTotal(String userId);

    Integer updateAddress(Object...obs);

}
