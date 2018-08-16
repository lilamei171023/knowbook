package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.*;
import com.excellent.knowbookcommon.dao.sudao.SubBookMapper;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.AddressTotal;
import com.excellent.knowbookcommon.model.vo.PurchasePage;
import com.excellent.knowbookcore.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import  java.util.UUID;

/**
 * @author User wxxu
 * @description: 购买页面实现类
 * @create 2018/8/7 22:34
 */
@Transactional(rollbackFor = KownBookException.class)
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private SubBookMapper subBookMapper;

    @Autowired
    private SellBookMapper sellBookMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderTotalMapper orderTotalMapper;

    /**
     * @author wxxu
     * @descriation 到支付页面
     * @param userId
     * @param bookId
     * @return PurchasePage
     * @date 2018/8/10 20:18
     */
    @Override
    public PurchasePage queryPurchase(String userId, String bookId) {
        //只有加入到购物车才会显示该界面
        if(insertShoppingCart(userId,bookId) != 1){
            return null;
        }
        PurchasePage purchasePage = new PurchasePage();
        purchasePage.setUserId(userId);

        //查询用户信息
        Users users = usersMapper.selectByPrimaryKey(userId);
        purchasePage.setUserName(users.getUserName());
        purchasePage.setUserPhone(users.getUserPhone());

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



    /**
     * @author wxxu
     * @descriation 个人地址
     * @param
     * @return
     * @date 2018/8/10 20:17
     */
    @Override
    public List<AddressTotal> queryAddressTotal(String userId) {

        List<AddressTotal> addressTotalList = new ArrayList<>();

        Users user = usersMapper.selectByPrimaryKey(userId);

        String userDefaultAddressId = user.getUserAddressId();

        //得到user所有address信息
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Address> addressList = addressMapper.selectByExample(addressExample);


        for (Address address: addressList
             ) {
            AddressTotal addressTotal = new AddressTotal();

            addressTotal.setUserId(address.getUserId());
            addressTotal.setAddressId(address.getAddressId());
            addressTotal.setAddresseeInfo(address.getAddresseeInfo());
            addressTotal.setAddresseeName(address.getAddresseeName());
            addressTotal.setAddresseePhone(address.getAddresseePhone());

            if(userDefaultAddressId != null){
                //添加默认地址id
                addressTotal.setUserDefaultAddressId(userDefaultAddressId);
            }

            addressTotalList.add(addressTotal);
        }

        return addressTotalList;
    }

    /**
     * @author wxxu
     * @descriation 修改地址，新增地址，设置默认地址
     * @param obs
     * @return Integer
     * @date 2018/8/10 20:17
     */
    @Override
    public Integer updateAddress(Object... obs) {
        Address address = null;
        String userDefaultAddressId = null;
        //2个参数，为更新和设置默认地址
        if(obs.length>1){
            address = (Address) obs[0];
            userDefaultAddressId = (String) obs[1];
        }
        int insertOrUpdate = 0;
        String addressId = null;
        //如果传回来的值没有addressId,则是新增地址，生成地址id
        if(address.getAddressId() == null ){
            addressId = UUID.randomUUID().toString().replaceAll("-","");
            address.setAddressId(addressId);
            //设置默认值
            address.setCreateTime(new Date());
            address.setCreateUser("王晓旭");
            address.setUpdateUser("wxx");
            address.setDeleted(0);

            insertOrUpdate = addressMapper.insert(address);
        }else if(address.getAddresseeInfo() != null && address.getAddresseeName() != null && address.getAddresseePhone() != null){
            //否则为更新,当传回的值不为空时进行修改
            insertOrUpdate = addressMapper.updateByPrimaryKeySelective(address);
        }

        //修改默认地址
        Users users = usersMapper.selectByPrimaryKey(address.getUserId());

        //当新增地址时，默认新地址为默认地址
        if(userDefaultAddressId.equals("0") && addressId != null){
            users.setUserAddressId(addressId);
        }else if(!userDefaultAddressId.equals("0")){
            users.setUserAddressId(userDefaultAddressId);
        }

        int defaultAddress = usersMapper.updateByPrimaryKey(users);

        return (defaultAddress == 1 || insertOrUpdate == 1) ? 1 : 0;
    }

    /**
     * @author wxxu
     * @descriation 点击购买商品时，将商品加入购物车
     * @param userId
     * @param bookId
     * @return Integer
     * @date 2018/8/10 20:28
     */
    @Override
    public Integer insertShoppingCart(String userId, String bookId) {

        ShoppingCart shoppingCart = new ShoppingCart();
        String uuID = UUID.randomUUID().toString().replaceAll("-","");

        shoppingCart.setShoppingCartId(uuID);
        shoppingCart.setBookId(bookId);
        shoppingCart.setUserId(userId);

        //设置默认值
        shoppingCart.setCreateUser("王晓旭");
        shoppingCart.setCreateTime(new Date());
        shoppingCart.setUpdateUser("wxx");

        Integer i = shoppingCartMapper.insertSelective(shoppingCart);

        return i;
    }

    /**
     * @author wxxu
     * @descriation 支付，扣除账户余额
     * 支付要操作6个表：购物车，用户表，订单明细表，订单总表,修改买书表中的书的状态,book表中书的状态
     * @param userId
     * @param bookId
     * @return Integer
     * @date 2018/8/10 20:29
     */
    @Override
    public Integer payment(String userId,String bookId) {

        OrderTotal orderTotal;
        OrderDetail orderDetail;
        //5个表的返回值来判断是否修改完成
        int shoppingCartUpdate = 0;
        int usersUpdate;
        int orderTotalUpdate;
        int orderDetailUpdate = 0;
        int sellBookUpdate = 0;
        int bookUpdate = 0;

        //得到钱包余额
        Users users = usersMapper.selectByPrimaryKey(userId);
        Double wallet = users.getWallet();

        //页面不确定，暂时这样写
        //当bookId不为0时,即默认值，代表是直接进入书本详情页来付款的，支付一本书
        if(!bookId.equals("0")){
            Book book = subBookMapper.selectByPrimaryKey(bookId);
            Double oneSpend = book.getBookNowPrice();
            if(wallet < oneSpend){
                //余额不足直接返回
                return (int) (wallet-oneSpend);
            }
            //1.更新个人钱包的余额
            Double newWallet = wallet - oneSpend;
            users.setWallet(newWallet);
            shoppingCartUpdate = usersMapper.updateByPrimaryKeySelective(users);

            //2.删除购物车中商品的存在
            ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
            ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();
            criteria.andBookIdEqualTo(bookId);
            criteria.andUserIdEqualTo(userId);
            List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);
            //根据userId和bookId查询的只可能有一个购物车
            usersUpdate = shoppingCartMapper.deleteByPrimaryKey(shoppingCarts.get(0).getShoppingCartId());

            //3.先在订单总表中加入订单号
            orderTotal = new OrderTotal();
            String orderId = UUID.randomUUID().toString().replaceAll("-","");
            orderTotal.setOrderId(orderId);
            orderTotal.setUserId(userId);
            orderTotal.setAddressId(users.getUserAddressId());
            orderTotal.setTotalPrice(oneSpend);
            orderTotal.setOrderStatus(0);
            //默认值
            orderTotal.setCreateTime(new Date());
            orderTotal.setCreateUser("王晓旭");
            orderTotal.setUpdateUser("wxx");
            orderTotalUpdate = orderTotalMapper.insertSelective(orderTotal);

            //4.再在订单明细表中填信息
            orderDetail = new OrderDetail();
            orderDetail.setBookId(bookId);
            orderDetail.setOrderId(orderId);
            //默认值
            orderDetail.setCreateTime(new Date());
            orderDetail.setCreateUser("王晓旭");
            orderDetail.setUpdateUser("wxx");
            orderDetailUpdate = orderDetailMapper.insertSelective(orderDetail);

            //5.修改卖书表的状态
            SellBookExample sellBookExample = new SellBookExample();
            SellBookExample.Criteria sellBookExampleCriteria = sellBookExample.createCriteria();
            sellBookExampleCriteria.andBookIdEqualTo(bookId);
            List<SellBook> sellBookList = sellBookMapper.selectByExample(sellBookExample);
            //根据书的id只能查到一条结果
            SellBook sellBook = sellBookList.get(0);
            sellBook.setDeleted(1);
            sellBookUpdate = sellBookMapper.updateByPrimaryKey(sellBook);

            //6.修改book表的书的状态
            book.setDeteled(1);
            bookUpdate = subBookMapper.updateByPrimaryKey(book);

        }else {//如果bookId为null，代表是在购物车提交订单支付的，直接查找购物车表中个人所有商品

            ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
            ShoppingCartExample.Criteria criteria = shoppingCartExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            //根据userId查出所有商品Id
            List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByExample(shoppingCartExample);
            Double moreSpend = 0.0;
            //得到总价
            for (ShoppingCart shoppingCart:shoppingCarts) {
                Book book = subBookMapper.selectByPrimaryKey(shoppingCart.getBookId());
                moreSpend += book.getBookNowPrice();
            }
            //余额不足直接返回
            if(wallet < moreSpend){
                return (int)(wallet-moreSpend);
            }

            //1.修改用户余额
            users.setWallet(wallet-moreSpend);
            usersUpdate = usersMapper.updateByPrimaryKeySelective(users);

            //2.先在订单总表中加入订单号
            orderTotal = new OrderTotal();
            String orderId = UUID.randomUUID().toString().replaceAll("-","");
            orderTotal.setOrderId(orderId);
            orderTotal.setUserId(userId);
            orderTotal.setAddressId(users.getUserAddressId());
            orderTotal.setTotalPrice(moreSpend);
            orderTotal.setOrderStatus(0);
            //默认值
            orderTotal.setCreateTime(new Date());
            orderTotal.setCreateUser("王晓旭");
            orderTotal.setUpdateUser("wxx");
            orderTotalUpdate = orderTotalMapper.insertSelective(orderTotal);

            //订单明细表添加订单详情；修改sellBook表中书的状态；修改书的状态；删除购物车的数据
            for (ShoppingCart s : shoppingCarts) {
                //3.添加订单详情
                orderDetail = new OrderDetail();
                orderDetail.setBookId(s.getBookId());
                orderDetail.setOrderId(orderId);
                //默认值
                orderDetail.setCreateTime(new Date());
                orderDetail.setCreateUser("王晓旭");
                orderDetail.setUpdateUser("wxx");
                orderDetailUpdate = orderDetailMapper.insertSelective(orderDetail);

                //4.修改sellBook表中的状态
                SellBookExample sellBookExample = new SellBookExample();
                SellBookExample.Criteria sellBookExampleCriteria = sellBookExample.createCriteria();
                sellBookExampleCriteria.andBookIdEqualTo(s.getBookId());
                List<SellBook> sellBookList = sellBookMapper.selectByExample(sellBookExample);
                //根据书的id只能查到一条结果
                SellBook sellBook = sellBookList.get(0);
                sellBook.setDeleted(1);
                sellBookUpdate = sellBookMapper.updateByPrimaryKey(sellBook);

                //5.修改书的状态
                Book book = subBookMapper.selectByPrimaryKey(s.getBookId());
                book.setDeteled(1);
                bookUpdate = subBookMapper.updateByPrimaryKeySelective(book);
                //6.删除购物车的数据
                shoppingCartUpdate = shoppingCartMapper.deleteByPrimaryKey(s.getShoppingCartId());
            }

        }

        return shoppingCartUpdate==1 && usersUpdate==1 && orderDetailUpdate==1
                && orderTotalUpdate==1 && sellBookUpdate==1 && bookUpdate==1 ? 1 : 0;
    }
}
