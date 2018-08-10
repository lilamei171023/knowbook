package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.BookMapper;
import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.BookExample;
import com.excellent.knowbookcore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/7
 * Description:
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<String> selectAllBookTheme() {
        BookExample example=new BookExample();
        example.setDistinct(true);
        example.setOrderByClause("book_theme");
        BookExample.Criteria critera=example.createCriteria();
        critera.andDeteledEqualTo(0);
        List<Book> list=bookMapper.selectByExample(example);
        List<String> list1=new ArrayList<>();
        for (Book b:list) {
            list1.add(b.getBookTheme());
        }
        return list1;
    }
}
