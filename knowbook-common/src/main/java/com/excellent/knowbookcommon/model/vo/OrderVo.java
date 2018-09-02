package com.excellent.knowbookcommon.model.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
public class OrderVo {
    private Integer id;
    private String userName; //users表
    private String userPhone;//
    private String addresseeInfo;//address表
    private String addresseeName;//
    private String addresseePhone;//
    private Integer orderStatus;//orderTotal表
    private Double totalPrice;
    private Date createTime;
    private List<BookVo>  BookVoByorder;

    public List<BookVo> getBookVoByorder() {
        return BookVoByorder;
    }

    public void setBookVoByorder(List<BookVo> bookVoByorder) {
        BookVoByorder = bookVoByorder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddresseeInfo() {
        return addresseeInfo;
    }

    public void setAddresseeInfo(String addresseeInfo) {
        this.addresseeInfo = addresseeInfo;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public String getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(String addresseePhone) {
        this.addresseePhone = addresseePhone;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
