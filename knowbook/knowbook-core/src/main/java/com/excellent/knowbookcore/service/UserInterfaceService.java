package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.vo.UserInterfaceVo;
import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcommon.model.vo.FollowVo;
import com.excellent.knowbookcommon.model.vo.TopicVo;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
public interface UserInterfaceService {
    List<BookVo> queryBookVo(String userId) throws Exception;
    List<TopicVo> queryTopicVo(String userId) throws Exception;
    List<FollowVo> queryfollowVo(String userId) throws Exception;
    UserInterfaceVo queryUserInterfaceVo(String userId) throws Exception;
    Integer insertComment(String userId,String youselfId) throws  Exception;

}
