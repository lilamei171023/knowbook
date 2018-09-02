package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.vo.BookDetailsPageVo;
import com.excellent.knowbookcommon.model.vo.HomepagePictureVo;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.model.vo.UserInterfaceVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/8.
 */
@RestController
@RequestMapping("/HomePageController")
public class HomePageController {

         @Autowired
         private HomePageService homePageService;



    /**
     * 主页推荐书籍
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/MyPageBookList")
    public ResultVo<List<BookDetailsPageVo>> MyPageBookList() throws Exception {

        ResultVo resultVo;
        List<BookDetailsPageVo> bookDetailsPageVoList=homePageService.MyPageBookList();
        if (bookDetailsPageVoList!= null) {
            resultVo = ResultUtils.success(bookDetailsPageVoList);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;

    }

    /**
     * 主页轮播图，随机给予
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/HomepagePicture")
    public ResultVo<List<HomepagePictureVo>> HomepagePicture() throws Exception {

        ResultVo resultVo;
        List<HomepagePictureVo> homepagePictureVo=homePageService.HomepagePicture();
        if (homepagePictureVo!= null) {
            resultVo = ResultUtils.success(homepagePictureVo);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;




    }
    }
