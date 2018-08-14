package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.pojo.Book;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/7
 * Description:
 */
public interface BookService {
    List<String> selectAllBookTheme();

    List<Book> selectAllBook();

    String  saveBook(Book book);

    List<Book> searchBook(Integer pageNumber,
                                 Integer pageSize,
                                 String searchContent);

}
