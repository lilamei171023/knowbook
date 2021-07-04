package com.excellent.knowbookweb.handle.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @User: Rowena
 * @Date: 2018/8/1
 * Description:
 */
//@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Value("${spring.profiles.active}")
    private String env;

    @Pointcut("execution(public * com.excellent.knowbookweb.controller.*.* (..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint)  {
        //url,method,ip,类方法，参数
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        logger.info("url={}", request.getRequestURI());
//        logger.info("method={}", request.getMethod());
//        logger.info("ip={}", request.getRemoteAddr());
//        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("args={}", joinPoint.getArgs());

        if("prod".equals(env)) {
            logger.info("-------------------当前是prod环境------------------");
        }else {
            logger.info("---------------------当前是dev环境---------------------");

        }
    }

    @After("log()")
    public void doAfter() {
        logger.info("-------------------------doAfter-----------------------------");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}





