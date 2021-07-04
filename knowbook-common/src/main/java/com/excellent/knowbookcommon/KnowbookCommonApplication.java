package com.excellent.knowbookcommon;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
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
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication

public class KnowbookCommonApplication {

	public static void main(String[] args) {

		SpringApplication.run(KnowbookCommonApplication.class, args);
	}


//	// 复合查询
//	@PostMapping("query/book/novel")
//	@ResponseBody
//	public ResponseEntity query(
//			@RequestParam(name = "author", required = false) String author,
//			@RequestParam(name = "title", required = false) String title,
//			@RequestParam(name = "gt_word_count", defaultValue = "0") int gtWordCount,
//			@RequestParam(name = "lt_word_count", required = false) Integer ltWordCount) {
//
//		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//
//		if (author != null) {
//			boolQuery.must(QueryBuilders.matchQuery("author", author));
//		}
//
//		if (title != null) {
//			boolQuery.must(QueryBuilders.matchQuery("title", title));
//		}
//
//		RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("word_count").from(gtWordCount);
//		if (ltWordCount != null && ltWordCount > 0) {
//			rangeQuery.to(ltWordCount);
//		}
//		boolQuery.filter(rangeQuery);
//
//		SearchRequestBuilder builder = client.prepareSearch(BOOK_INDEX).setTypes(BOOK_TYPE_NOVEL)
//				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//				.setQuery(boolQuery)
//				.setFrom(0)
//				.setSize(10);
//
//		logger.debug(builder.toString());
//
//		SearchResponse response = builder.get();
//
//		List result = new ArrayList<Map<String, Object>>();
//		for (SearchHit hit : response.getHits()) {
//			result.add(hit.getSourceAsMap());
//		}
//
//		return new ResponseEntity(result, HttpStatus.OK);
//
//	}
}
