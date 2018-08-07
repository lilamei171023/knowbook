package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.MyCollection;
import com.excellent.knowbookcommon.model.vo.BookDetailsPage;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author User wxxu
 * @description: 商品详情页的Controller层
 * @create 2018/8/7 20:32
 */
@RestController
@RequestMapping("/bookDetails")
public class BookDetailsController {

    @Autowired
    private BookDetailsService bookDetailsService;

    @PostMapping(value = "/queryBookDetails")
    public ResultVo<List<BookDetailsPage>> queryBookDetails(@RequestParam("bookId") String bookId){

        ResultVo resultVo;

        BookDetailsPage bookDetailsPage = bookDetailsService.queryBookDetail(bookId);

        if(bookDetailsPage != null){
            resultVo = ResultUtils.success(bookDetailsPage);
        }else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;

    }

    @PutMapping(value = "/collectionBook")
    public ResultVo<Integer> insertMyCollection(@Valid MyCollection myCollection){

        //前端得到2个数据
        myCollection.setBookId(myCollection.getBookId());
        myCollection.setUserId(myCollection.getUserId());

        //默认数据
        myCollection.setCreateUser("王晓旭");
        myCollection.setCreateTime(new Date());
        myCollection.setUpdateUser("wxx");
        myCollection.setDeleted(0);


        ResultVo resultVo;
        Integer i = bookDetailsService.insertCollection(myCollection);

        if(i!=null && i!= 0){
            resultVo = ResultUtils.success(i);
        }else{
            resultVo = ResultUtils.fail();
        }

        return resultVo;

    }

}
