package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.pojo.UsersExample;
import com.excellent.knowbookcommon.model.vo.UsersRegisterVo;
import com.excellent.knowbookcommon.utils.Md5Utils;
import com.excellent.knowbookcommon.utils.SendsmsUtils;
import com.excellent.knowbookcore.service.UserManagementService;
import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 高楚杭 on 2018/8/9.
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int registered(Users user) throws Exception {
        UsersExample userexample=new UsersExample();
        UsersExample.Criteria usercriteria=userexample.createCriteria();
        String uuid= UUID.randomUUID().toString().replace("-", "");
        user.setUserId(uuid);
        user.setUserPassword(Md5Utils.generate(user.getUserPassword()));
        user.setCreateTime(new Date());
        user.setCreateUser(user.getUserName());
        user.setUpdateUser(user.getUserName());
        user.setUserAddressId("中国");
        user.setUserNumber(user.getUserPhone());
        user.setWallet(800000.00);
        user.setUserPicture("url");
        int i=usersMapper.insertSelective(user);
        return i;
    }

    @Override
    public String Login(String userNumber, String userPassword) throws Exception {
        UsersExample userexample=new UsersExample();
        UsersExample.Criteria usercriteria=userexample.createCriteria();
         usercriteria.andUserNumberEqualTo(userNumber);
        List<Users> usersList=usersMapper.selectByExample(userexample);
        if (usersList.isEmpty()){
            return  "0";//用户名错误
        }
         Users users=usersList.get(0);
        boolean ok=Md5Utils.verify(userPassword,users.getUserPassword());
        if (ok){
            return  users.getUserId();//登录成功
        }else {
            return  "2";//密码错误
        }
    }
        int code=0;

    /**
     * 生成发送短信码
     * @param userPhone
     * @return
     * @throws Exception
     */
    @Override
    public  int  sendUserPhone(String userPhone) throws Exception {
        code= SendsmsUtils.SendText(userPhone);
            if (code!=0){ return  1;}
             else {return  3;}
    }

    /**
     * 验证短信码
     * @param userPhone
     * @param sendCode
     * @return
     * @throws Exception
     */
    @Override
    public int  sendText(String userPhone,int sendCode) throws Exception {
                if (sendCode==code){
                    code=0;
                    return 1;
                }else {
                    code=0;
                    return 3;
                }
    }
}
