package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.Topic;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.QueryAllVo;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.BookService;
import com.excellent.knowbookcore.service.TopicService;
import com.excellent.knowbookcore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private TopicService topicService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/findTheme",method = RequestMethod.POST)
    public ResultVo findAllTheme(){
        if(bookService.selectAllBookTheme().size()!=0){
          return   ResultUtils.success(bookService.selectAllBookTheme());
        }else {
            return ResultUtils.fail("查询失败。");
        }

    }

    @PostMapping(value = "/queryBySearchContent")
    public ResultVo<QueryAllVo> queryBySearchContent(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                     @RequestParam(value = "searchContent") String searchContent){
        if("".equals(searchContent)||searchContent==null){
            List<Book> list=bookService.selectAllBook();
           return  ResultUtils.success(list);
        }else{
            QueryAllVo queryAllVo=new QueryAllVo();
            queryAllVo.setBookList(bookService.searchBook(pageNumber, pageSize,searchContent));
            queryAllVo.setTopicList(topicService.searchTopic(pageNumber, pageSize,searchContent));
            queryAllVo.setUsersList(usersService.searchUsers(pageNumber, pageSize,searchContent));
           return  ResultUtils.success(queryAllVo);
        }

    }
}
