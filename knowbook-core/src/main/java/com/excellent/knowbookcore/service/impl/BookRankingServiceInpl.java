package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.BookMapper;
import com.excellent.knowbookcommon.dao.MyCollectionMapper;
import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.BookExample;
import com.excellent.knowbookcommon.model.pojo.MyCollection;
import com.excellent.knowbookcommon.model.pojo.MyCollectionExample;
import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcore.service.BookRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by 高楚杭 on 2018/8/9.
 */
@Service
public class BookRankingServiceInpl implements BookRankingService{

    @Autowired
    private BookMapper bookMapper;
    /**
     *
     * @param sign
     * @return
     * @throws Exception
     */
    @Override
    public List<BookVo> bookCollectionRangking(String sign) throws Exception {
        BookExample bookExample=new BookExample();
        BookExample.Criteria criteria=bookExample.createCriteria();
        if (sign.equals("0")){
            bookExample.setOrderByClause("collection_count DESC");
        }
        if (sign.equals("1")){
            bookExample.setOrderByClause("collection_count ASC");
        }
        List<Book> bookList=bookMapper.selectByExample(bookExample);
        List<BookVo> bookVoList=new ArrayList<>();
        for (Book book: bookList) {
            BookVo bookVo=new BookVo();
            bookVo.setBookId(book.getBookId());
            bookVo.setBookAuthor(book.getBookAuthor());
            bookVo.setBookPress(book.getBookPress());
            bookVo.setBookPicture(book.getBookPicture());
            bookVo.setCreateTime(book.getCreateTime());
            bookVo.setBookName(book.getBookName());
            bookVoList.add(bookVo);
        }


        return bookVoList;
    }

    @Override
    public List<BookVo> bookCreataTimeRanking(String sign) throws Exception {
        BookExample bookExample=new BookExample();
        BookExample.Criteria criteria=bookExample.createCriteria();
        if (sign.equals("0")){
            bookExample.setOrderByClause("create_time DESC");
        }
        if (sign.equals("1")){
            bookExample.setOrderByClause("create_time ASC");
        }
        List<Book> bookList=bookMapper.selectByExample(bookExample);
        List<BookVo> bookVoList=new ArrayList<>();
        for (Book book: bookList) {
            BookVo bookVo=new BookVo();
            bookVo.setBookId(book.getBookId());
            bookVo.setBookPress(book.getBookPress());
            bookVo.setBookPicture(book.getBookPicture());
            bookVo.setCreateTime(book.getCreateTime());
            bookVo.setBookName(book.getBookName());
            bookVo.setBookAuthor(book.getBookAuthor());
            bookVoList.add(bookVo);

        }


        return bookVoList;
    }



    @Override
    public List<BookVo> bookLikeRanking() throws Exception {
        BookExample bookExample=new BookExample();
        BookExample.Criteria criteria=bookExample.createCriteria();
        criteria.andDeteledEqualTo(0);
        List<Book> bookList=bookMapper.selectByExample(bookExample);
        int y=bookList.size();
        int real;
      if (y<10){
          real=y;
      }else {
          real=10;
      }
        ArrayList<Integer> arrayList=new ArrayList();
        int x=0;
        for(int i=0;i<real;i++){
            do {
                Random rand =new Random();
                x=rand.nextInt(y);
            }
            while (arrayList.contains(x));
            arrayList.add(x);
        }

        List<BookVo> bookVoList=new ArrayList<>();
        for (Integer i:arrayList) {
            Book book=   bookList.get(i);
            BookVo bookVo=new BookVo();
            bookVo.setBookId(book.getBookId());
            bookVo.setBookPress(book.getBookPress());
            bookVo.setBookPicture(book.getBookPicture());
            bookVo.setCreateTime(book.getCreateTime());
            bookVo.setBookName(book.getBookName());
            bookVo.setBookAuthor(book.getBookAuthor());
            bookVoList.add(bookVo);
        }
        return bookVoList;

    }
}
