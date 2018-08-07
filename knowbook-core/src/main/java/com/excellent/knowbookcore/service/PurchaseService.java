package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.vo.PurchasePage;

/**
 * 购买逻辑层
 */
public interface PurchaseService {

    PurchasePage queryPurchase(String userId,String bookId);

}
