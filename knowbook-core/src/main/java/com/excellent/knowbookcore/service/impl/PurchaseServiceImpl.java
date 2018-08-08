package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.AddressMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.dao.sudao.SubBookMapper;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.AddressTotal;
import com.excellent.knowbookcommon.model.vo.PurchasePage;
import com.excellent.knowbookcore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import  java.util.UUID;

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
     * 加一个同步锁
     * @param obs
     * @return
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
}
