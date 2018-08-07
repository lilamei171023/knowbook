package com.excellent.knowbookcommon.model.vo;

/**
 * @author User wxxu
 * @description: 购买界面包装类
 * @create 2018/8/7 22:20
 */
public class PurchasePage {

    private String userId;

    private String userName;

    private String userPhone;

    private String addressId;

    private String addresseeInfo;

    private String bookId;

    private String bookPicture;

    private double bookNowPrice;

    /**
     * 送达时间
     */
    private String serviceDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookPicture() {
        return bookPicture;
    }

    public void setBookPicture(String bookPicture) {
        this.bookPicture = bookPicture;
    }

    public double getBookNowPrice() {
        return bookNowPrice;
    }

    public void setBookNowPrice(double bookNowPrice) {
        this.bookNowPrice = bookNowPrice;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getAddresseeInfo() {
        return addresseeInfo;
    }

    public void setAddresseeInfo(String addresseeInfo) {
        this.addresseeInfo = addresseeInfo;
    }

    @Override
    public String toString() {
        return "PurchasePage{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", addressId='" + addressId + '\'' +
                ", addresseeInfo='" + addresseeInfo + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookPicture='" + bookPicture + '\'' +
                ", bookNowPrice=" + bookNowPrice +
                ", serviceDate='" + serviceDate + '\'' +
                '}';
    }
}
