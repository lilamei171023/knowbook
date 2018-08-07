package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.AddressMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.dao.sudao.SubBookMapper;
import com.excellent.knowbookcommon.model.pojo.Address;
import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.PurchasePage;
import com.excellent.knowbookcore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author User wxxu
 * @description: 购买页面实现类
 * @create 2018/8/7 22:34
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private SubBookMapper subBookMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public PurchasePage queryPurchase(String userId, String bookId) {
        PurchasePage purchasePage = new PurchasePage();
        purchasePage.setUserId(userId);

        //查询用户信息
        Users users = usersMapper.selectByPrimaryKey(userId);
        purchasePage.setUserName(users.getUserName());
        purchasePage.setUserPhone(users.getUserPhone());

        System.out.println(users.getUserAddressId());

        //得到默认地址信息
        Address address = addressMapper.selectByPrimaryKey(users.getUserAddressId());
        purchasePage.setAddressId(users.getUserAddressId());
        purchasePage.setAddresseeInfo(address.getAddresseeInfo());

        purchasePage.setBookId(bookId);
        //得到book信息
        Book book = subBookMapper.selectByPrimaryKey(bookId);
        purchasePage.setBookPicture(book.getBookPicture());
        purchasePage.setBookNowPrice(book.getBookNowPrice());

        //算出查收时间
        Date currentDate = new Date();
        currentDate.setDate(currentDate.getDate()+2);
        String serviceDate = currentDate.getMonth()+1+"月"+currentDate.getDate()+"日(周"+currentDate.getDay()+")";
        purchasePage.setServiceDate(serviceDate);

        return purchasePage;
    }
}
