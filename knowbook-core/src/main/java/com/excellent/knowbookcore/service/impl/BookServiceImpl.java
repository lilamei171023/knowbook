package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.BookMapper;
import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.BookExample;
import com.excellent.knowbookcommon.repository.BookRepository;
import com.excellent.knowbookcore.service.BookService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/7
 * Description:
 */
@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<String> selectAllBookTheme() {
        BookExample example = new BookExample();
        example.setDistinct(true);
        example.setOrderByClause("book_theme");
        BookExample.Criteria critera = example.createCriteria();
        critera.andDeteledEqualTo(0);
        List<Book> list = bookMapper.selectByExample(example);
        List<String> list1 = new ArrayList<>();
        for (Book b : list) {
            list1.add(b.getBookTheme());
        }
        return list1;
    }

    @Override
    public List<Book> selectAllBook() {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andDeteledEqualTo(0);
        List<Book> list = bookMapper.selectByExample(example);
        if (list.size() != 0) {
            return list;
        } else {
            return null;
        }

    }

    @Override
    public String saveBook(Book book) {

        Book bookResult = bookRepository.save(book);
        return bookResult.getBookId();
    }

    @Override
    public List<Book> searchBook(Integer pageNumber,
                                 Integer pageSize,
                                 String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("bookname", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("description", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        logger.info("\n searchBook(): searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());

        Page<Book> searchPageResults = bookRepository.search(searchQuery);
        return searchPageResults.getContent();
    }
}
