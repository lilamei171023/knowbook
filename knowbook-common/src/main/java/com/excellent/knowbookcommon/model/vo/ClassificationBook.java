package com.excellent.knowbookcommon.model.vo;

/**
 * @author User wxxu
 * @description: 分类页面书的属性
 * @create 2018/8/6 20:15
 */
public class ClassificationBook {

    private String bookId;

    private String bookPicture;

    private String userId;

    private String userName;

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

    @Override
    public String toString() {
        return "ClassificationBook{" +
                "bookId='" + bookId + '\'' +
                ", bookPicture='" + bookPicture + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
