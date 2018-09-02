package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.vo.*;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */

@RestController
@RequestMapping("/UserInterfaceController")
public class UserInterfaceController {
    @Autowired
    private UserInterfaceService userInterfaceService;

          /**根据用户id查找的他的书籍**/
    @RequestMapping(value = "/queryBookVo", method = RequestMethod.GET)
    public ResultVo<List<BookVo>> queryBookVo(String userId) throws Exception {
        ResultVo resultVo;
        List<BookVo> bookVos= userInterfaceService.queryBookVo(userId);
        if (bookVos!= null) {
            resultVo = ResultUtils.success(bookVos);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    /**根据用户id查找的他的话题**/
    @RequestMapping(value = "/queryTopicVo", method = RequestMethod.GET)
    public ResultVo<List<TopicVo>> queryTopicVo(String userId) throws Exception {
        ResultVo resultVo;
        List<TopicVo> topicVos= userInterfaceService.queryTopicVo(userId);
        if (topicVos!= null) {
            resultVo = ResultUtils.success(topicVos);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    /**根据用户id查找的他的关注**/
    @RequestMapping(value = "/queryfollowVo", method = RequestMethod.GET)
    public ResultVo<List<FollowVo>> queryfollowVo(String userId) throws Exception {
        ResultVo resultVo;
        List<FollowVo> followVos=userInterfaceService.queryfollowVo(userId);
        if (followVos!= null) {
            resultVo = ResultUtils.success(followVos);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    /**根据用户id查找的他的基本信息 名字，头像**/
    @RequestMapping(value = "/queryUserInterfaceVo", method = RequestMethod.GET)
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

    @RequestMapping(value = "/insertComment", method = RequestMethod.POST)
    public  ResultVo<Integer> insertComment(String userId, String yourselfId) throws Exception {


        ResultVo resultVo;
        Integer i=userInterfaceService.insertComment(userId,yourselfId);
        if (i!= 0) {
            resultVo = ResultUtils.success(i);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    }
