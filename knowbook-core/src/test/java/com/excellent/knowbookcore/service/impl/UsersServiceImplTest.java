package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcore.service.UsersService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/8/3
 * Description:
 */
public class UsersServiceImplTest {
    @Autowired
    private UsersService usersService;
    @Test
    public void queryUsers() throws Exception {
        List<Users> userList=usersService.queryUsers("001");
        Assert.assertEquals(1,userList.size());
    }

    @Test
    public void insertUser() {
        Users users=new Users();
        users.setUserName("张三001");
        users.setUserPassword("11111");
        int i=usersService.insertUser(users);
        Assert.assertEquals(1,i);
    }

    @Test
    public void saveUsers() {
        List<Users> usersList=usersService.selectAll();
        for (Users users:usersList) {
            usersService.saveUsers(users);
        }
    }
}