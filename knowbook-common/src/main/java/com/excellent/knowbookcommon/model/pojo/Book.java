package com.excellent.knowbookcommon.model.pojo;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String bookId;

    private Integer id;

    private String bookName;

    private String bookAuthor;

    private String bookQuality;

    private String bookPress;

    private Double bookBeforePrice;

    private Double bookNowPrice;

    private String bookPicture;

    private String bookStyle;

    private String bookTheme;

    private String bookLangerages;

    private Integer bookIsSell;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer deteled;

    private String bookInfo;

    private String bookRemarks;

    private static final long serialVersionUID = 1L;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookQuality() {
        return bookQuality;
    }

    public void setBookQuality(String bookQuality) {
        this.bookQuality = bookQuality;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
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

    public String getBookPicture() {
        return bookPicture;
    }

    public void setBookPicture(String bookPicture) {
        this.bookPicture = bookPicture;
    }

    public String getBookStyle() {
        return bookStyle;
    }

    public void setBookStyle(String bookStyle) {
        this.bookStyle = bookStyle;
    }

    public String getBookTheme() {
        return bookTheme;
    }

    public void setBookTheme(String bookTheme) {
        this.bookTheme = bookTheme;
    }

    public String getBookLangerages() {
        return bookLangerages;
    }

    public void setBookLangerages(String bookLangerages) {
        this.bookLangerages = bookLangerages;
    }

    public Integer getBookIsSell() {
        return bookIsSell;
    }

    public void setBookIsSell(Integer bookIsSell) {
        this.bookIsSell = bookIsSell;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDeteled() {
        return deteled;
    }

    public void setDeteled(Integer deteled) {
        this.deteled = deteled;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public String getBookRemarks() {
        return bookRemarks;
    }

    public void setBookRemarks(String bookRemarks) {
        this.bookRemarks = bookRemarks;
    }
}