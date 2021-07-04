package com.excellent.knowbookweb.controller;


import com.excellent.knowbookcommon.KnowbookCommonApplication;
import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcore.service.BookService;
import com.excellent.knowbookweb.KnowbookWebApplication;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @User: Rowena
 * @Date: 2018/8/10
 * Description:
 */
@RestController
public class EsController {

    public static final Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    // 查询接口
    @GetMapping("/get/book/novel")
    public List<Book> searchBook(@RequestParam(value = "pageNumber") Integer pageNumber,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "searchContent") String searchContent) {
        return bookService.searchBook(pageNumber, pageSize,searchContent);
    }

}
