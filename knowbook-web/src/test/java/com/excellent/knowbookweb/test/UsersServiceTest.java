package com.excellent.knowbookweb.test;

import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcore.service.UsersService;
import com.excellent.knowbookweb.KnowbookWebApplication;
import org.apache.tomcat.jni.Thread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @User: Rowena
 * @Date: 2018/8/11
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KnowbookWebApplication.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void saveUsers() {
        List<Users> usersList=usersService.selectAll();
        for (Users users:usersList) {
            usersService.saveUsers(users);
        }
//        ConcurrentHashMap
//        HashMap
//        Hashtable
//        Thread
//        ExecutorService
//        AtomicInteger
//        CopyOnWriteArrayList
//        ArrayList
    }
}
