package com.excellent.knowbookcore.service;


import com.excellent.knowbookcommon.model.pojo.MyCollection;
import com.excellent.knowbookcommon.model.vo.BookDetailsPage;

/**
 * 商品详情页的逻辑处理
 */
public interface BookDetailsService {

    BookDetailsPage queryBookDetail(String bookId);

    Integer insertCollection(MyCollection myCollection);
}
