package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcore.service.UsersService;
import com.excellent.knowbookcommon.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/findAll")
    public ResultVo<Object>  findAll() {
//        return usersService.findAll();
        ResultVo resultVo;
        resultVo = ResultUtils.success();
        return resultVo;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResultVo<Object> index() {
        ResultVo resultVo;
        resultVo = ResultUtils.success();
        return resultVo;

    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResultVo<Object> select() {
        ResultVo resultVo;
        resultVo = ResultUtils.success();
        return resultVo;

    }



}
