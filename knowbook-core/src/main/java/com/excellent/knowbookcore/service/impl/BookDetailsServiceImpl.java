package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.BookMapper;
import com.excellent.knowbookcommon.dao.MyCollectionMapper;
import com.excellent.knowbookcommon.dao.SellBookMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.dao.sudao.SubBookMapper;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.BookDetailsPage;
import com.excellent.knowbookcore.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author User wxxu
 * @description: book详情页实现类
 * @create 2018/8/7 20:08
 */
@Transactional(rollbackFor = KownBookException.class)
@Service
public class BookDetailsServiceImpl implements BookDetailsService{

    @Autowired
    private SubBookMapper subBookMapper;

    @Autowired
    private SellBookMapper sellBookMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private MyCollectionMapper myCollectionMapper;

    @Override
    public BookDetailsPage queryBookDetail(String bookId) {

        Book book = subBookMapper.selectByPrimaryKey(bookId);

        BookDetailsPage bookDetailsPage = new BookDetailsPage();
        bookDetailsPage.setBookId(book.getBookId());
        bookDetailsPage.setBookName(book.getBookName());
        bookDetailsPage.setBookInfo(book.getBookInfo());
        bookDetailsPage.setBookNowPrice(book.getBookNowPrice());
        //计算折扣，保留一位小数(几.几折)
        Double discount = book.getBookNowPrice()/book.getBookBeforePrice();
        BigDecimal bigDecimal = new BigDecimal(discount);
        discount = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()*10;

        bookDetailsPage.setBookDiscount(discount);
        bookDetailsPage.setCollectionCount(book.getCollectionCount());
        bookDetailsPage.setBookPress(book.getBookPress());

        //得到卖家信息
        SellBookExample sellBookExample = new SellBookExample();
        SellBookExample.Criteria criteria = sellBookExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        //得到list集合，实际上只有一个结果，一本书只能有一个卖家
        List<SellBook> sellBookList = sellBookMapper.selectByExample(sellBookExample);

        Users user = null;

        for (SellBook sellBook: sellBookList  ) {
            user = usersMapper.selectByPrimaryKey(sellBook.getUserId());
        }

        bookDetailsPage.setUserId(user.getUserId());
        bookDetailsPage.setUserName(user.getUserName());
        bookDetailsPage.setUserPicture(user.getUserPicture());

        return bookDetailsPage;
    }

    @Override
    public Integer insertCollection(MyCollection myCollection) {

        //默认数据
        myCollection.setCreateUser("王晓旭");
        myCollection.setCreateTime(new Date());
        myCollection.setUpdateUser("wxx");

        //插入到收藏表
        int insert = myCollectionMapper.insertSelective(myCollection);

        //修改book收藏数量
        Book book = bookMapper.selectByPrimaryKey(myCollection.getBookId());
        Integer count = book.getCollectionCount()+1;
        book.setCollectionCount(count);
        int i = bookMapper.updateByPrimaryKey(book);

        return (insert==1 && i==1) ? 1 : 0;
    }
}
