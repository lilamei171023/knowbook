package com.excellent.knowbookcommon.utils;

import java.util.UUID;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */

public class CreateIDUtils {
   public static String CreatId(){
       return UUID.randomUUID().toString().replaceAll("-","");
   }
}
