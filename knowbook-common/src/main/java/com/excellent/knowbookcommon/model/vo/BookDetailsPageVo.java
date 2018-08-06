package com.excellent.knowbookcommon.model.vo;

/**
 * @author User wxxu
 * @description: 图书详情页初始值
 * @create 2018/8/6 16:15
 */
public class BookDetailsPageVo {

    private String bookId;

    private String bookName;

    private String bookPicture;

    private String bookInfo;

    private Integer collectionCount;

    private Double bookBeforePrice;

    private Double bookNowPrice;

    private String userId;

    private String userName;

    private String userPicture;

    private String bookPress;

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

    public String getBookPicture() {
        return bookPicture;
    }

    public void setBookPicture(String bookPicture) {
        this.bookPicture = bookPicture;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(Integer collectionCount) {
        this.collectionCount = collectionCount;
    }

    public Double getBookBeforePrice() {
        return bookBeforePrice;
    }

    public void setBookBeforePrice(Double bookBeforePrice) {
        this.bookBeforePrice = bookBeforePrice;
    }

    public Double getBookNowPrice() {
        return bookNowPrice;
    }

    public void setBookNowPrice(Double bookNowPrice) {
        this.bookNowPrice = bookNowPrice;
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

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    @Override
    public String toString() {
        return "BookDetailsPageVo{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPicture='" + bookPicture + '\'' +
                ", bookInfo='" + bookInfo + '\'' +
                ", collectionCount=" + collectionCount +
                ", bookBeforePrice=" + bookBeforePrice +
                ", bookNowPrice=" + bookNowPrice +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPicture='" + userPicture + '\'' +
                ", bookPress='" + bookPress + '\'' +
                '}';
    }
}
