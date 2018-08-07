package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.vo.ClassificationBook;
import com.excellent.knowbookcommon.model.vo.ClassificationPage;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author User wxxu
 * @description: 分类页Controller层
 * @create 2018/8/6 20:58
 */
@RestController
@RequestMapping(value = "/classification")
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;


    @GetMapping(value = "/queryClassification")
    public ResultVo<List<ClassificationPage>> queryClassificationPage(){
        ResultVo resultVo;
        ClassificationPage classificationPage = classificationService.queryClassificationPage();

        if(classificationPage != null){
            resultVo = ResultUtils.success(classificationPage);
        }else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    @PostMapping(value = "/queryClassificationBooks")
    public ResultVo<List<ClassificationBook>> queryClassificationBooks(@Valid Book book, @RequestParam(value = "welcomeIndex",defaultValue = "0") Integer welcomeIndex){
        book.setBookStyle(book.getBookStyle());
        book.setBookTheme(book.getBookTheme());
        book.setBookLanguage(book.getBookLanguage());

        ResultVo resultVo;

        List<ClassificationBook> bookList = classificationService.queryBooks(book,welcomeIndex);

        if(bookList != null){
            resultVo = ResultUtils.success(bookList);
        }else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

}
