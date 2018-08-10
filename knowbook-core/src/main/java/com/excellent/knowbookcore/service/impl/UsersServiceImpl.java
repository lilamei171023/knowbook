package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.sub.SubUsersMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.pojo.UsersExample;
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
    private SubUsersMapper usersMapper;
    @Override
    public List<Users> queryUsers(String  userId) throws Exception{
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.UIDEQUALNULL);
        }
        List<Users> usersList=new ArrayList<>();
        Users users=usersMapper.selectByPrimaryKey(userId);
        usersList.add(users);
        return usersList;
    }

    @Override
    public Integer insertUser(Users users) {
        if(users.getUserName()==null){
            throw new KownBookException(ResultEnum.ERROR);
        }
        return usersMapper.insertSelective(users);
    }

    @Override
    public List<Users> selectAll() {
       return usersMapper.selectAll();

    }

    @Override
    public Users selectUserByUserId(String userId) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeteledEqualTo(0);
        List<Users> usersList=usersMapper.selectByExample(example);
        return usersList.get(0);
    }


}
