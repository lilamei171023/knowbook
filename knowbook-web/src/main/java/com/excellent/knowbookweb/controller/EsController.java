package com.excellent.knowbookweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @User: Rowena
 * @Date: 2018/8/16
 * Description:
 */
@RestController
@ResponseBody
public class EsController {
    @Autowired
    private TransportClient client;

    @GetMapping("/")
    public String index(){return "index";}


    @GetMapping("book/novel")
    public ResponseEntity get(@RequestParam(name = "id",defaultValue = "") String id){
        if(id.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result =  this.client.prepareGet("book","novel", id).get();

        if(!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(),HttpStatus.OK);
    }

    @PostMapping("add/book/novel")
    public ResponseEntity add(@RequestParam(name = "title") String title,
                              @RequestParam(name = "author") String author,
                              @RequestParam(name = "word_count") int wordCount){
        try {
           XContentBuilder contentBuilder= XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title",title)
                    .field("author",author)
                    .field("word_count",wordCount)
//                    .field("publish_date",publishDate)
                    .endObject();
            IndexResponse response= this.client.prepareIndex("book","novel")
                    .setSource(contentBuilder)
                    .get();
            return new ResponseEntity(response.getId(),HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("get/all/books")
    public JSONArray getall(){


        MatchAllQueryBuilder qu = QueryBuilders.matchAllQuery();

        SearchResponse sr = client.prepareSearch("book")
                .setQuery(qu)
                .get();
        JSONArray jsonArray = new JSONArray();
        SearchHits hist = sr.getHits();
        for (SearchHit hs : hist) {

            Map source = hs.getSource();

            JSONObject json = (JSONObject) JSON.toJSON(source);

            jsonArray.add(json);
        }
        return jsonArray;
    }

    @GetMapping("get/all/desc")
    public JSONArray getdesc(){
        MatchAllQueryBuilder qu = QueryBuilders.matchAllQuery();
        SearchResponse sr = client.prepareSearch("book")
                .addSort("id", SortOrder.DESC)
                .get();
        JSONArray jsonArray = new JSONArray();
        SearchHits hist = sr.getHits();
        for (SearchHit hs : hist) {

            Map source = hs.getSource();

            JSONObject json = (JSONObject) JSON.toJSON(source);

            jsonArray.add(json);
        }
        return jsonArray;
    }

    @GetMapping("get/match/books")
    public JSONArray getsome(@RequestParam(name="book_name",defaultValue = "")String book_name){

        MatchQueryBuilder builder = QueryBuilders.matchQuery("book_name",book_name);

        SearchResponse response = client.prepareSearch("book")
                .setQuery(builder)
                .get();
        SearchHits searchHits = response.getHits();

        JSONArray jsonArray = new JSONArray();
        SearchHits hist = response.getHits();
        for(SearchHit hs:hist){
            Map source = hs.getSource();
            JSONObject json = (JSONObject) JSON.toJSON(source);
            jsonArray.add(json);
        }
        return jsonArray;
    }
}
