package com.excellent.knowbookcommon.utils;

import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.vo.ResultVo;

/**
 * @User: Rowena
 * @Date: 2018/7/31
 * Description:
 */

public class ResultUtils {
    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(object);
        return resultVo;
    }
    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo fail() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.FAIL.getCode());
        resultVo.setMsg(ResultEnum.FAIL.getMsg());
        return resultVo;
    }

    public static ResultVo error() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.ERROR.getCode());
        resultVo.setMsg(ResultEnum.ERROR.getMsg());
        return resultVo;
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }


    public static ResultVo fail(String string) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(300+Integer.valueOf(string));
        if (Integer.valueOf(string)==0){
            resultVo.setMsg("用户不存在");}
        else if (Integer.valueOf(string)==2){
            resultVo.setMsg("密码错误");
        }else if(Integer.valueOf(string)==3) {
            resultVo.setMsg("验证码错误");
        }else {
            resultVo.setMsg("未知错误，请检查网络");
        }
        resultVo.setData(Integer.valueOf(string));
        return resultVo;

    }
}
