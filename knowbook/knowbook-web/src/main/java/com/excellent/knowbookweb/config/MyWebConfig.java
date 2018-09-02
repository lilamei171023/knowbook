package com.excellent.knowbookweb.config;

import com.excellent.knowbookweb.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @User: Rowena
 * @Date: 2018/8/1
 * Description:
 */
@Configuration
@ComponentScan
public class MyWebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    public LoginInterceptor loginInterceptor;
    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //用户登录拦截器
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").        //拦截所有请求
                excludePathPatterns("/usersController/login").       //排除拦截的请求
                excludePathPatterns("/usersController/index");


        super.addInterceptors(registry);
    }

}
