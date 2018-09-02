package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.BookMapper;
import com.excellent.knowbookcommon.dao.SellBookMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.BookDetailsPageVo;
import com.excellent.knowbookcommon.model.vo.HomepagePictureVo;
import com.excellent.knowbookcore.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by 高楚杭 on 2018/8/8.
 */
@Service
public class HomePageServiceImpl implements HomePageService {

        @Autowired
        private BookMapper bookMapper;
        @Autowired
        private UsersMapper usersMapper;
        @Autowired
        private SellBookMapper sellBookMapper;
    /**
     * 根据书本id查找书籍信息
     * @param bookId
     * @return
     */
        public BookDetailsPageVo queryBookDetailById(String bookId) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
            BookDetailsPageVo bookDetailsPageVo = new BookDetailsPageVo();
        bookDetailsPageVo.setBookId(book.getBookId());
            bookDetailsPageVo.setBookName(book.getBookName());
            bookDetailsPageVo.setBookInfo(book.getBookInfo());
            bookDetailsPageVo.setBookNowPrice(book.getBookNowPrice());

        //计算折扣，保留一位小数(几.几折)
        Double discount = book.getBookNowPrice()/book.getBookBeforePrice();
        BigDecimal bigDecimal = new BigDecimal(discount);
        discount = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()*10;

            bookDetailsPageVo.setBookDiscount(discount);
            bookDetailsPageVo.setCollectionCount(book.getCollectionCount());
            bookDetailsPageVo.setBookPress(book.getBookPress());

        //得到卖家信息
        SellBookExample sellBookExample = new SellBookExample();
        SellBookExample.Criteria criteria = sellBookExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        //得到list集合，实际上只有一个结果，一本书只能有一个卖家
        List<SellBook> sellBookList =sellBookMapper.selectByExample(sellBookExample);

        Users user = null;

        for (SellBook sellBook: sellBookList  ) {
            user = usersMapper.selectByPrimaryKey(sellBook.getUserId());
        }

            bookDetailsPageVo.setUserId(user.getUserId());
            bookDetailsPageVo.setUserName(user.getUserName());
            bookDetailsPageVo.setUserPicture(user.getUserPicture());

        return bookDetailsPageVo;
    }

    /**
     * 主页推荐书籍
     * @return
     * @throws Exception
     */
    @Override
    public List<BookDetailsPageVo> MyPageBookList() throws Exception {

         BookExample bookExample=new BookExample();
         BookExample.Criteria criteria=bookExample.createCriteria();
         criteria.andDeteledEqualTo(0);
         List<Book> bookList=bookMapper.selectByExample(bookExample);
        int y=bookList.size();
        int result=0;
        if (y>4){
            result =4;
        }else {
            result=y;
        }

        ArrayList<Integer> arrayList=new ArrayList();
        int d=0;
        for(int i=0;i<result;i++){
            do {
                Random rand =new Random();
                d=rand.nextInt(y);
            }
            while (arrayList.contains(d));
            arrayList.add(d);
        }

        List<BookDetailsPageVo> bookDetailsPageVoList=new ArrayList<>();
        for (Integer i:arrayList) {
            bookDetailsPageVoList.add(queryBookDetailById(bookList.get(i).getBookId()));
        }



        return bookDetailsPageVoList;
    }






    @Override
    public List<HomepagePictureVo> HomepagePicture() throws Exception {
        BookExample bookExample=new BookExample();
        BookExample.Criteria criteria=bookExample.createCriteria();
        criteria.andDeteledEqualTo(0);
        List<Book> bookList=bookMapper.selectByExample(bookExample);
        int y=bookList.size();
        ArrayList<Integer> arrayList=new ArrayList();
        int d=0;
        for(int i=0;i<3;i++){
            do {
                Random rand =new Random();
                d=rand.nextInt(y);
            }
            while (arrayList.contains(d));
            arrayList.add(d);
        }
        List<HomepagePictureVo> HomepagePictureVoList=new ArrayList<>();
        for (Integer i:arrayList) {
            HomepagePictureVo homepagePictureVo=new HomepagePictureVo();
            homepagePictureVo.setBookId(bookList.get(i).getBookId());
            homepagePictureVo.setBookPicture(bookList.get(i).getBookId());
            HomepagePictureVoList.add(homepagePictureVo);
        }


        return HomepagePictureVoList;
    }



}
