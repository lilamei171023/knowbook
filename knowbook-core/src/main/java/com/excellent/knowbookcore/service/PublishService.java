package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.pojo.Book;

/**
 * 发布接口
 */
public interface PublishService {
    Integer publishBook(Book book,String userId);
}
