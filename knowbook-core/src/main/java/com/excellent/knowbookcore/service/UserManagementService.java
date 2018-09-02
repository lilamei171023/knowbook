package com.excellent.knowbookcore.service;

import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.vo.UsersRegisterVo;

import javax.servlet.http.HttpSession;

/**
 * Created by 高楚杭 on 2018/8/9.
 */
public interface UserManagementService {

      int registered(Users user) throws  Exception;

      String Login(String userNumber, String userPassword) throws Exception;

      int sendUserPhone (String userPhone) throws  Exception;

       int  sendText(String userPhone,int sendCode) throws Exception;

      }
