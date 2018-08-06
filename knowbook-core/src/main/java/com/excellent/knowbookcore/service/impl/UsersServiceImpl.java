package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/7/31
 * Description:
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersDao;
    @Override
    public List<Users> queryUsers(String  userId) throws Exception{
        if(userId==null){
            throw new KownBookException(ResultEnum.ERROR);
        }
        List<Users> usersList=new ArrayList<>();
        Users users=usersDao.selectByPrimaryKey(userId);
        usersList.add(users);
        return usersList;
    }

    @Override
    public Integer insertUser(Users users) {
        if(users.getUserName()==null){
            throw new KownBookException(ResultEnum.ERROR);
        }
        return usersDao.insertSelective(users);
    }


}
