package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.vo.*;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.MyPageService;
import com.excellent.knowbookcore.service.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
@RestController
@RequestMapping("/MyPageController")
public class MyPageController {

    @Autowired
    private UserInterfaceService userInterfaceService;
    @Autowired
    private MyPageService myPageService;

    /**根据用户id查找的他的基本信息 名字，头像**/
    @RequestMapping(value = "/queryMyPageByUserVo", method = RequestMethod.GET)
    public ResultVo<UserInterfaceVo> queryUserInterfaceVo(String userId) throws Exception {
        ResultVo resultVo;
        UserInterfaceVo userInterfaceVo=userInterfaceService.queryUserInterfaceVo(userId);
        if (userInterfaceVo!= null) {
            resultVo = ResultUtils.success(userInterfaceVo);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }


    /**根据用户id查找的他的话题**/
    @RequestMapping(value = "/queryMyPageByTopicVo", method = RequestMethod.GET)
    public ResultVo<List<TopicVo>> queryMyPageByTopicVo(String userId) throws Exception {
        ResultVo resultVo;
        List<TopicVo> topicVos= userInterfaceService.queryTopicVo(userId);
        if (topicVos!= null) {
            resultVo = ResultUtils.success(topicVos);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    /**根据用户id查找的他的书籍**/
    @RequestMapping(value = "/queryMyPageByBookVo", method = RequestMethod.GET)
    public ResultVo<List<BookVo>> queryMyPageByBookVo(String userId) throws Exception {
        ResultVo resultVo;
        List<BookVo> bookVos= userInterfaceService.queryBookVo(userId);
        if (bookVos!= null) {
            resultVo = ResultUtils.success(bookVos);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    /***
     *订单查询
     * @param userId
     * @return 订单列表
     * @throws Exception
     */
    @RequestMapping(value = "/queryMyPageOrder", method = RequestMethod.GET)
    public   ResultVo<List<OrderVo>>  queryMyPageOrder(String userId) throws Exception {
        ResultVo resultVo;
        List<OrderVo> orderVoList=myPageService.queryMyPageOrder(userId);
        System.out.println(orderVoList.size());
        if (orderVoList!= null) {
            resultVo = ResultUtils.success(orderVoList);
        } else {
            resultVo = ResultUtils.fail();
        }
        return  resultVo;
    }

    /**
     *我的页面中的收藏中 ，收藏的书籍
     * @param userId
     * @return 书籍列表
     * @throws Exception
     */
    @RequestMapping(value = "/queryMyCollectionByBook", method = RequestMethod.GET)
    public ResultVo<List<BookVo>>queryMyCollectionByBook(String userId) throws Exception{
        ResultVo resultVo;
        List<BookVo>  bookVoList=myPageService.queryMyCollectionByBook(userId);
        if (bookVoList!= null) {
            resultVo = ResultUtils.success(bookVoList);
        } else {
            resultVo = ResultUtils.fail();
        }
        return  resultVo;
    }
}

