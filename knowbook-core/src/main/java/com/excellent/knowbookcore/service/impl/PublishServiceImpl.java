package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.SellBookMapper;
import com.excellent.knowbookcommon.dao.sudao.SubBookMapper;
import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.SellBook;
import com.excellent.knowbookcommon.utils.QiNiuUtils;
import com.excellent.knowbookcore.service.PublishService;
import com.qiniu.common.QiniuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author User wxxu
 * @description: 发布控制层
 * //@Transactional这个注解说明这个方法就已经交由springboot事物管理.如果这个方法中有一个操作失败，就全部失败
 * @create 2018/8/8 17:24
 */

@Transactional(rollbackFor = KownBookException.class)
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    private SubBookMapper subBookMapper;

    @Autowired
    private SellBookMapper sellBookMapper;

    @Override
    public Integer publishBook(Book book,String userId) {

        QiNiuUtils qiNiuUtils = new QiNiuUtils();

        //设置默认值和初始值
        String uuID = UUID.randomUUID().toString().replaceAll("-","");
        book.setBookId(uuID);
        book.setCollectionCount(0);
        book.setCreateTime(new Date());
        book.setCreateUser("王晓旭");
        book.setUpdateUser("wxx");

        //实现上传图片功能
        String file = book.getBookPicture();
        file.replaceAll("/","\\");
        String fileName = file.substring(file.lastIndexOf("\\")+1);
        String realPath = null;
        try {
            realPath = qiNiuUtils.uploadImg(file,fileName);
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        //如果未得到图片链接地址，抛出异常
        if(realPath != null){
            book.setBookPicture(realPath);
        }else {
            System.err.println("上传失败");
            throw new KownBookException(ResultEnum.ERROR);
        }
        Integer i = subBookMapper.insertSelective(book);

        Integer integer = 0;
        //将发布的书加入到买书表中
        if(i==1){
            SellBook sellBook = new SellBook();
            sellBook.setUserId(userId);
            sellBook.setBookId(book.getBookId());
            sellBook.setCreateTime(new Date());
            sellBook.setCreateUser("王晓旭");
            sellBook.setUpdateUser("wxx");
            integer = sellBookMapper.insertSelective(sellBook);
        }



        return (i==1 && integer==1) ? 1 : 0;
    }
}
