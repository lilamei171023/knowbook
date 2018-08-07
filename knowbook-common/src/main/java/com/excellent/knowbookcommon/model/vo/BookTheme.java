package com.excellent.knowbookcommon.model.vo;

/**
 * @author User wxxu
 * @description: book题材类
 * @create 2018/8/6 20:13
 */
public class BookTheme {

    private  String bookTheme;

    public String getBookTheme() {
        return bookTheme;
    }

    public void setBookTheme(String bookTheme) {
        this.bookTheme = bookTheme;
    }

    @Override
    public String toString() {
        return "BookTheme{" +
                "bookTheme='" + bookTheme + '\'' +
                '}';
    }
}
