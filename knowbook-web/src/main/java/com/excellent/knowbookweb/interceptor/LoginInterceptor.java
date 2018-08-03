package com.excellent.knowbookweb.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @User: Rowena
 * @Date: 2018/8/1
 * Description:
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Value("${spring.profiles.active}")
    private String env;

    /**
     * 在请求处理之前进行调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
         logger.info("--------------------------preHandle-------------------------------");
         HttpSession session = request.getSession(true);
//        session.setAttribute("userId",001);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if( "prod".equals(env)) {
            if (session.getAttribute("userId") == null) {
                logger.info("--------------------------:跳转到login页面！--------------------------");
                response.sendRedirect(request.getContextPath() + "/usersController/login");
                return false;
            } else {
                logger.info("--------------------------此用户已经存。-------------------------------");
                session.setAttribute("userId", session.getAttribute("userId"));
                return true;
            }

           }
            else {
                return true;
            }

    }

    /*private boolean isLoginRequired(Method method) {
        if (!env.equals("prod")) { //只有生产环境才需要登录
            return false;
        }
        boolean result = true;
        if(method.isAnnotationPresent(Permission.class)){
            result = method.getAnnotation(Permission.class).loginReqired();
        }
        return result;
    }*/

}
