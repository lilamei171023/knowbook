package com.excellent.knowbookcommon.model.vo;

/**
 * Created by 高楚杭 on 2018/8/8.
 */


public class BookDetailsPageVo {

    private String bookId;

    private String bookName;

    private Integer collectionCount;

    private String bookInfo;


    private Double bookNowPrice;

    /**
     * 折扣
     */
    private Double bookDiscount;

    private String bookPress;

    private String userId;

    private String userName;

    private String userPicture;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(Integer collectionCount) {
        this.collectionCount = collectionCount;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Double getBookNowPrice() {
        return bookNowPrice;
    }

    public void setBookNowPrice(Double bookNowPrice) {
        this.bookNowPrice = bookNowPrice;
    }

    public Double getBookDiscount() {
        return bookDiscount;
    }

    public void setBookDiscount(Double bookDiscount) {
        this.bookDiscount = bookDiscount;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

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

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public String toString() {
        return "BookDetailsPage{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", collectionCount=" + collectionCount +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookNowPrice=" + bookNowPrice +
                ", bookDiscount=" + bookDiscount +
                ", bookPress='" + bookPress + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPicture='" + userPicture + '\'' +
                '}';
    }
}