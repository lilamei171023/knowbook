package com.excellent.knowbookcommon.model.pojo;

import java.io.Serializable;

public class ShoppingCar implements Serializable {
    private String shoppingCarId;

    private Integer id;

    private String userId;

    private String bookId;

    private static final long serialVersionUID = 1L;

    public String getShoppingCarId() {
        return shoppingCarId;
    }

    public void setShoppingCarId(String shoppingCarId) {
        this.shoppingCarId = shoppingCarId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}