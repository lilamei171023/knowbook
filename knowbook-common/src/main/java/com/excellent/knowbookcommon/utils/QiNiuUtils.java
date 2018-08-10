package com.excellent.knowbookcommon.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.util.UUID;

/**
 * @author User wxxu
 * @description: 七牛云上传图片
 * @create 2018/8/10 14:31
 */
public class QiNiuUtils {

    private final static String ACCESS_KEY = "V1r6FHqLeNYRwvS2TA99vZXZdqjQc2YwY0P8vtlM";

    private final static String SECRET_KEY = "fvF8P7ynww5TkaUVgh2uX1DrE_Up_8cHEgd-EZvB";

    private final static String BUCKET = "know-book";

    private final static String PATH = "http://pd7blgo4u.bkt.clouddn.com/";

    private final static Auth AUTH = Auth.create(ACCESS_KEY, SECRET_KEY);

    public String uploadImg(String filePath,String oldName) throws QiniuException {
        //构造配置类，zone.zone1()代表华北区
        Configuration configuration = new Configuration(Zone.zone1());
        UploadManager uploadManager = new UploadManager(configuration);

        //生成凭证
        String upToken = AUTH.uploadToken(BUCKET);

        //文件扩展名
        String FileExtName = oldName.substring(oldName.lastIndexOf(".")+1);
        //修改文件名，避免重复
        String newFileName = "know-"+ UUID.randomUUID().toString().replaceAll("-","")+"."+FileExtName;

        //创建上传对象
        Response response = uploadManager.put(filePath,newFileName,upToken);

        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);

        //获得返回的文件名
        String key = putRet.key;

        //获取图片路径
        String realPath = PATH+key;

        return realPath;
    }

}
