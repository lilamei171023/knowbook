package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.BookVo;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 高楚杭 on 2018/8/10.
 */
@RestController
@RequestMapping("/person")
public class UserManagementController {
    @Autowired
    private UserManagementService userManagementService;

    /**
     * 注册（Md5随机盐加密）
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResultVo<Integer> registered(Users user) throws Exception {
        ResultVo resultVo;
        Integer registered = userManagementService.registered(user);
        if (registered != 0) {
            resultVo = ResultUtils.success(registered);
        } else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    /**
     * 登录
     * @param userNumber
     * @param userPassword
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ResultVo<Integer> Login(String userNumber, String userPassword) throws Exception {

     ResultVo resultVo;
        String  registered = userManagementService.Login(userNumber,userPassword);
        if (registered .length()>1) {
            resultVo = ResultUtils.success(registered);
        }
       else {
            resultVo = ResultUtils.fail(registered);
        }
        return resultVo;
    }

    /**
     * 生成发送短信码
     * @param userPhone
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sendUserPhone", method = RequestMethod.POST)
    public  ResultVo<Integer>  sendUserPhone(String userPhone) throws Exception {

        ResultVo resultVo;
       int registered = userManagementService.sendUserPhone(userPhone);
        if (registered==1) {
            resultVo = ResultUtils.success(registered);
        }
        else {
            resultVo = ResultUtils.fail(String.valueOf(registered));
        }
        return resultVo;

    }

    /**
     * 验证短信码
     * @param userPhone
     * @param sendCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sendText", method = RequestMethod.POST)
    public  ResultVo<Integer>  sendText(String userPhone,int sendCode) throws Exception {

        ResultVo resultVo;
        int registered = userManagementService.sendText(userPhone,sendCode);
        if (registered==1) {
            resultVo = ResultUtils.success(registered);
        }
        else {
            resultVo = ResultUtils.fail(String.valueOf(registered));
        }
        return resultVo;

    }

}