package com.excellent.knowbookcommon.model.vo;

/**
 * @author User wxxu
 * @description: book文体类
 * @create 2018/8/6 20:12
 */
public class BookStyle {

    private String bookStyle;

    public String getBookStyle() {
        return bookStyle;
    }

    public void setBookStyle(String bookStyle) {
        this.bookStyle = bookStyle;
    }

    @Override
    public String toString() {
        return "BookStyle{" +
                "bookStyle='" + bookStyle + '\'' +
                '}';
    }
}
