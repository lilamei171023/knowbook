package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @User: Rowena
 * @Date: 2018/8/7
 * Description:
 */
@RestController
@RequestMapping("/bookController")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/findTheme",method = RequestMethod.POST)
    public ResultVo findAllTheme(){
        if(bookService.selectAllBookTheme().size()!=0){
          return   ResultUtils.success(bookService.selectAllBookTheme());
        }else {
            return ResultUtils.fail("查询失败。");
        }

    }
}
