package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcore.service.UsersService;
import com.excellent.knowbookcommon.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/7/30
 * Description:
 */
@RestController
@RequestMapping("/usersController")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/queryUsers", method = RequestMethod.GET)
    public ResultVo<List<Users>> queryUsers(String userId) throws Exception {
        ResultVo resultVo;
        if (usersService.queryUsers(userId) != null) {
            resultVo = ResultUtils.success(usersService.queryUsers(userId));
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ResultVo<Object> add(Users users) {
        ResultVo resultVo;
        if (usersService.insertUser(users) != 0) {
            resultVo = ResultUtils.success(users);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
        
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultVo<Object> login() {
        ResultVo resultVo;
        resultVo = ResultUtils.success();
        return resultVo;

    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Users> findAll() {
        return usersService.selectAll();

    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResultVo<Object> select() {
        ResultVo resultVo;
        resultVo = ResultUtils.success();
        return resultVo;

    }

//    @PostMapping(value = "/queryBySearchContent")
//    public ResultVo<List<Users>> queryBySearchContent(String searchContent){
//        if("".equals(searchContent)||searchContent==null){
//            List<Users> list=usersService.selectAllUsers();
//            return  ResultUtils.success(list);
//        }else{
//            List<Users> list= usersService.searchUsers(searchContent);
//            return  ResultUtils.success(list);
//        }
//
//    }



}
