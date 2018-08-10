package com.excellent.knowbookcommon.dao.sub;

import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.pojo.Users;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/7
 * Description:
 */
public interface SubUsersMapper extends UsersMapper{
    List<Users> selectAll();
}
