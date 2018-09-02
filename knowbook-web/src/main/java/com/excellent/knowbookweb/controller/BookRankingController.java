package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.vo.BookDetailsPageVo;
import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.BookRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/9.
 */
@RestController
@RequestMapping("/BookRankingController")
public class BookRankingController {
    @Autowired
    private BookRankingService bookRankingService;

    /**
     * 按收藏量排序，有升降两种情况
     * @param sign
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookCollectionRangking",method = RequestMethod.GET)
    public ResultVo<List<BookVo>> bookCollectionRangking(String sign) throws Exception {

        ResultVo resultVo;
        List<BookVo> bookDetailsPageVoList=bookRankingService.bookCollectionRangking(sign);
        if (bookDetailsPageVoList!= null) {
            resultVo = ResultUtils.success(bookDetailsPageVoList);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;

    }

    /**
     * 按创建时间排序，有升降两种情况
     * @param sign
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookCreataTimeRanking",method = RequestMethod.GET)
    public ResultVo<List<BookVo>> bookCreataTimeRanking(String sign) throws Exception {
        ResultVo resultVo;
        List<BookVo> bookDetailsPageVoList=bookRankingService.bookCreataTimeRanking(sign);
        if (bookDetailsPageVoList!= null) {
            resultVo = ResultUtils.success(bookDetailsPageVoList);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;

    }


    /**
     * 可能喜欢，随机进行访问
     * @param sign
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookLikeRanking",method = RequestMethod.GET)
    public ResultVo<List<BookVo>> bookLikeRanking(String sign) throws Exception {
        ResultVo resultVo;
        List<BookVo> bookDetailsPageVoList=bookRankingService.bookLikeRanking();
        if (bookDetailsPageVoList!= null) {
            resultVo = ResultUtils.success(bookDetailsPageVoList);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;

    }
}
