package com.excellent.knowbookcommon.model.vo;

import java.util.List;

/**
 * @author User wxxu
 * @description: 分类页面封装实体类
 * @create 2018/8/6 19:39
 */
public class ClassificationPage {

    private List<BookStyle> bookStyles;

    private List<BookTheme> bookThemes;

    private List<ClassificationBook> books;

    public List<BookStyle> getBookStyles() {
        return bookStyles;
    }

    public void setBookStyles(List<BookStyle> bookStyles) {
        this.bookStyles = bookStyles;
    }

    public List<BookTheme> getBookThemes() {
        return bookThemes;
    }

    public void setBookThemes(List<BookTheme> bookThemes) {
        this.bookThemes = bookThemes;
    }

    public List<ClassificationBook> getBooks() {
        return books;
    }

    public void setBooks(List<ClassificationBook> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ClassificationPage{" +
                "bookStyles=" + bookStyles +
                ", bookThemes=" + bookThemes +
                ", books=" + books +
                '}';
    }
}
