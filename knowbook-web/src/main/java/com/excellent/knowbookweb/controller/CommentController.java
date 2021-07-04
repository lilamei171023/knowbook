package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Comment;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
@RestController
@RequestMapping("/commentController")
public class CommentController {
    @Autowired
    private CommentService commentService;

    private static Logger logger= LoggerFactory.getLogger(CommentController.class);

    /**
     * 添加评论
     * @param comment
     * @param session
     * @return
     */
    @RequestMapping(value = "/addCommit",method = RequestMethod.POST)
    public ResultVo addCommit(@RequestBody Comment comment, HttpSession session){
        session.setAttribute("userId",002);
        comment.setUserId(session.getAttribute("userId").toString());
        comment.setCommentId(UUID.randomUUID().toString().substring(0,30));
        logger.info(comment.getCommentId());
        int id=  commentService.addComment(comment);
        if(id!=0){
            return ResultUtils.success("评论成功");
        }else {
            return   ResultUtils.fail("添加评论失败.");
        }
    }
}
