package com.excellent.knowbookcommon.repository;

import com.excellent.knowbookcommon.model.pojo.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @User: Rowena
 * @Date: 2018/8/11
 * Description:
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book,Long> {
}
