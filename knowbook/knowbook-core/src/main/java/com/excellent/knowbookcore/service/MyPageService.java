package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcommon.model.vo.OrderVo;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
public interface MyPageService {

    List<BookVo> queryBookVoByorder(String userId) throws Exception;

    List<OrderVo> queryMyPageOrder(String userId) throws Exception;

    List<BookVo> queryMyCollectionByBook(String userId) throws Exception;


}
