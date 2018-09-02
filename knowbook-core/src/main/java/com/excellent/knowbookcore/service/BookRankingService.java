package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.vo.BookVo;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/9.
 */
public interface BookRankingService {

   List<BookVo> bookCollectionRangking(String sign) throws Exception;

   List <BookVo>  bookCreataTimeRanking(String sign) throws  Exception;

    List<BookVo>  bookLikeRanking() throws  Exception;

}
