package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.*;
import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcommon.model.vo.OrderVo;
import com.excellent.knowbookcore.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
@Service
public class MyPageServiceImpl implements MyPageService{

@Autowired

private OrderDetailMapper orderDetailMapper;

@Autowired
private BookMapper bookMapper;

    @Autowired
    private OrderTotalMapper orderTotalMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private  MyCollectionMapper myCollectionMapper;

    /**
     *
     * @param orderId  订单ID
     * @return 订单里的书籍信息
     * @throws Exception
     */
    @Override
    public List<BookVo> queryBookVoByorder(String orderId) throws Exception {
        if(orderId==null||"".equals(orderId)){
            throw new KownBookException(ResultEnum.ERROR);
        }
        List<BookVo> bookVoList=new ArrayList<>();
        OrderDetailExample example=new OrderDetailExample();
        OrderDetailExample.Criteria criteria=example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderDetail> bookIdList=orderDetailMapper.selectByExample(example);
        for (OrderDetail orderDetail:bookIdList) {
            String bookId= orderDetail.getBookId();
            Book book=bookMapper.selectByPrimaryKey( bookId);
            BookVo bookVo=new BookVo();
            bookVo.setBookId( bookId);
            bookVo.setBookName(book.getBookName());
            bookVo.setBookPicture(book.getBookPicture());
            bookVo.setBookAuthor(book.getBookAuthor());
            bookVo.setBookPress(book.getBookPress());
            bookVo.setCreateTime(book.getCreateTime());
            bookVoList.add(bookVo);
        }

        return bookVoList;
    }


    /**
     *
     * @param userId
     * @return 返回我是所用订单的基本信息
     * @throws Exception
     */
    @Override
    public   List<OrderVo> queryMyPageOrder(String userId) throws Exception {
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.ERROR);
        }
             OrderTotalExample orderTotalExample=new OrderTotalExample();
             OrderTotalExample.Criteria criteria=orderTotalExample.createCriteria();

             criteria.andUserIdEqualTo(userId);
            List<OrderTotal> orderTotalList=orderTotalMapper.selectByExample(orderTotalExample);

             List<OrderVo> orderVoList=new ArrayList<>();

        for (OrderTotal orderTotal: orderTotalList) {
            OrderVo orderVo=new OrderVo();
            String addressId=orderTotal.getAddressId();
            orderVo.setCreateTime(orderTotal.getCreateTime());
            orderVo.setId(orderTotal.getId());
            orderVo.setOrderStatus(orderTotal.getOrderStatus());
            orderVo.setTotalPrice(orderTotal.getTotalPrice());
            orderVo.setUserName(usersMapper.selectByPrimaryKey(userId).getUserNumber());
            orderVo.setUserPhone(usersMapper.selectByPrimaryKey(userId).getUserPhone());
            orderVo.setAddresseeInfo(addressMapper.selectByPrimaryKey(addressId).getAddresseeInfo());
            orderVo.setAddresseeName(addressMapper.selectByPrimaryKey(addressId).getAddresseeName());
            orderVo.setAddresseePhone(addressMapper.selectByPrimaryKey(addressId).getAddresseePhone());
            orderVo.setBookVoByorder(queryBookVoByorder(orderTotal.getOrderId()));
            orderVoList.add(orderVo);
        }
         return  orderVoList;
    }



    /**
     *我的页面中的收藏中 ，收藏的书籍
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<BookVo> queryMyCollectionByBook(String userId) throws Exception {
           MyCollectionExample example=new MyCollectionExample();
           MyCollectionExample.Criteria criteria=example.createCriteria();
           criteria.andUserIdEqualTo(userId);
           List<MyCollection> MyCollectionList=myCollectionMapper.selectByExample(example);
        List<BookVo> bookVoList=new ArrayList<>();
        for (MyCollection myCollection: MyCollectionList) {
             BookVo bookVo=new BookVo();
              Book book=bookMapper.selectByPrimaryKey(myCollection.getBookId());
            bookVo.setCreateTime(book.getCreateTime());
            bookVo.setBookPicture(book.getBookPicture());
            bookVo.setBookPress(book.getBookPress());
            bookVo.setBookName(book.getBookName());
            bookVo.setBookAuthor(book.getBookAuthor());
            bookVo.setBookId(book.getBookId());
            bookVoList.add(bookVo);
        }


        return bookVoList;
    }

}
