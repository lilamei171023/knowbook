package com.excellent.knowbookweb.handle;

import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @User: Rowena
 * @Date: 2018/8/1
 * Description:统一异常处理类
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handle(Exception e) {
        if (e instanceof KownBookException) {
//            KownBookException kownBookException = (KownBookException) e;
            logger.error("【抛出异常】{}", e.getMessage());
            return ResultUtils.error();
        } else
            logger.error("【抛出异常】{}", e.getMessage());
        return ResultUtils.error(ResultEnum.UknError.getCode(), ResultEnum.UknError.getMsg());
    }
}
