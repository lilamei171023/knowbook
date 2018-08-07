package com.excellent.knowbookcommon.dao.sudao;

import com.excellent.knowbookcommon.dao.BookMapper;

import java.util.List;

public interface SubBookMapper extends BookMapper {

    List<String> queryBookStyle();

    List<String> queryBookTheme();
}
