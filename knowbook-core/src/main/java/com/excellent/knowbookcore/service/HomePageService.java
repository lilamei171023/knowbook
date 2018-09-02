package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.vo.BookDetailsPageVo;
import com.excellent.knowbookcommon.model.vo.HomepagePictureVo;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/8.
 */
public interface HomePageService {


     BookDetailsPageVo queryBookDetailById(String bookId) throws Exception;


     List<BookDetailsPageVo>MyPageBookList() throws Exception;

    List<HomepagePictureVo>HomepagePicture() throws Exception;




}
