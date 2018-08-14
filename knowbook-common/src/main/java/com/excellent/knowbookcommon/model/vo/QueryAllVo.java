package com.excellent.knowbookcommon.model.vo;

import com.excellent.knowbookcommon.model.pojo.Book;
import com.excellent.knowbookcommon.model.pojo.Topic;
import com.excellent.knowbookcommon.model.pojo.Users;
import lombok.Data;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/11
 * Description:
 */
@Data
public class QueryAllVo {

    List<Book>  bookList;

    List<Topic> topicList;

    List<Users> usersList;
}
