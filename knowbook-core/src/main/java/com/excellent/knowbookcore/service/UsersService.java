package com.excellent.knowbookcore.service;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/7/30
 * Description:
 */
public interface UsersService {
     List<Users> queryUsers(String userId) throws Exception;

     Integer insertUser(Users users);

     List<Users> findAll();
}
