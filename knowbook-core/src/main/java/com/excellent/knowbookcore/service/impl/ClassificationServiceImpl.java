package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.SellBookMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.dao.sudao.SubBookMapper;
import com.excellent.knowbookcommon.model.pojo.*;
import com.excellent.knowbookcommon.model.vo.BookStyle;
import com.excellent.knowbookcommon.model.vo.BookTheme;
import com.excellent.knowbookcommon.model.vo.ClassificationBook;
import com.excellent.knowbookcommon.model.vo.ClassificationPage;
import com.excellent.knowbookcore.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author User wxxu
 * @description: 分类页实现类
 * @create 2018/8/6 20:40
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private SubBookMapper bookMapper;

    @Autowired
    private SellBookMapper sellBookMapper;

    @Autowired
    private UsersMapper usersMapper;




    @Override
    public List<ClassificationBook> queryBooks(Object...obs) {

        Book books = null;
        Integer welcome = null;
        if(obs.length > 1){
            books = (Book) obs[0];
            welcome = (Integer) obs[1];
        }

        List<ClassificationBook> classificationBookList = new ArrayList<>();

        BookExample bookExample = new BookExample();

        BookExample.Criteria criteria = bookExample.createCriteria();

        //条件查询,题材，文体，语种
        if(books != null){
            if(books.getBookStyle() != null){
                criteria.andBookStyleEqualTo(books.getBookStyle());
            }
            if(books.getBookTheme() != null){
                criteria.andBookThemeEqualTo(books.getBookTheme());
            }
            if(books.getBookLanguage() != null){
                criteria.andBookLanguageEqualTo(books.getBookLanguage());
            }
        }

        //默认按照收藏个数降序排列
        if( welcome == null ||welcome == 0 ){
            bookExample.setOrderByClause("collection_count DESC");
        }else{
            bookExample.setOrderByClause("collection_count ASC");
        }

        List<Book> bookList = bookMapper.selectByExample(bookExample);

        ClassificationBook classificationBook = null;

        for (Book book: bookList) {
            classificationBook = new ClassificationBook();
            SellBookExample sellBookExample = new SellBookExample();

            //设置书的id,图片
            classificationBook.setBookId(book.getBookId());
            classificationBook.setBookPicture(book.getBookPicture());

            //查询卖家
            SellBookExample.Criteria sellBookExampleCriteria = sellBookExample.createCriteria();
            sellBookExampleCriteria.andBookIdEqualTo(book.getBookId());

            List<SellBook> sellBooks = sellBookMapper.selectByExample(sellBookExample);

            //设置卖家id
            classificationBook.setUserId(sellBooks.get(0).getUserId());
            Users users = usersMapper.selectByPrimaryKey(sellBooks.get(0).getUserId());
            //设置卖家名
            classificationBook.setUserName(users.getUserName());

            classificationBookList.add(classificationBook);
        }

        return classificationBookList;
    }


    @Override
    public List<BookStyle> queryBookStyle() {

        List<BookStyle> bookStyleList = new ArrayList<>();

        List<String> stringList = bookMapper.queryBookStyle();

        BookStyle bookStyle = null;
        for (int i = 0; i < stringList.size(); i++) {
            //限定显示个数
            if(i==4){
                break;
            }
            bookStyle = new BookStyle();
            bookStyle.setBookStyle(stringList.get(i));
            bookStyleList.add(bookStyle);
        }

        return bookStyleList;
    }

    @Override
    public List<BookTheme> queryBookTheme() {

        List<BookTheme> bookThemeList = new LinkedList<>();

        List<String> stringList = bookMapper.queryBookTheme();

        BookTheme bookTheme = null;
        for (String str: stringList ) {
            //限定显示个数
            if(bookThemeList.size()==5){
                break;
            }
            bookTheme = new BookTheme();
            bookTheme.setBookTheme(str);
            bookThemeList.add(bookTheme);
        }

        return bookThemeList;
    }

    @Override
    public ClassificationPage queryClassificationPage() {

        ClassificationPage classificationPage = new ClassificationPage();

        classificationPage.setBooks(this.queryBooks());

        classificationPage.setBookStyles(this.queryBookStyle());

        classificationPage.setBookThemes(this.queryBookTheme());

        return classificationPage;
    }
}
