package com.excellent.knowbookcommon.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
@Data
public class CommentVo {

    private String  userId;
    private String  userName;
    private Date createTime;
    private String  commentInfo;
    private String  userPicture;
    private String  praise;


}
