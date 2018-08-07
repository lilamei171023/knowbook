package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.vo.BookStyle;
import com.excellent.knowbookcommon.model.vo.BookTheme;
import com.excellent.knowbookcommon.model.vo.ClassificationBook;
import com.excellent.knowbookcommon.model.vo.ClassificationPage;

import java.util.List;

/**
 * @author User wxxu
 * @description: 分类页面service层
 * @create 2018/8/6 20:04
 */
public interface ClassificationService {

    List<ClassificationBook> queryBooks(Object...obs);

    List<BookStyle> queryBookStyle();

    List<BookTheme> queryBookTheme();

    ClassificationPage queryClassificationPage();
}
