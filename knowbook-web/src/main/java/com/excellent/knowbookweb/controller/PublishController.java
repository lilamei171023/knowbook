package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author User wxxu
 * @description: 发布书
 * @create 2018/8/8 19:43
 */
@RestController
@RequestMapping("/publishController")
public class PublishController {

    @Autowired
    private PublishService publishService;

    @PutMapping(value = "/publishBook")
    public ResultVo<Integer> publishBook(@Valid Book book, @RequestParam("userId") String userId){

        ResultVo resultVo;
        Integer i = publishService.publishBook(book,userId);
        if(i!=0 || i!=null){
            resultVo = ResultUtils.success(i);
        }else{
            resultVo = ResultUtils.fail();
        }
        return resultVo;

    }

}
