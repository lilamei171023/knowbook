package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.dto.TopicPo;
import com.excellent.knowbookcommon.model.pojo.Comment;
import com.excellent.knowbookcommon.model.pojo.Topic;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.model.vo.TopicDetails;
import com.excellent.knowbookcommon.model.vo.TopicsVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * @User: Rowena
 * @Date: 2018/8/6
 * Description:
 */
@RestController
@RequestMapping("/topicController")
public class TopicController {
    @Autowired
    private TopicService topicService;

    private static Logger logger = LoggerFactory.getLogger(TopicController.class);

    /**
     * 发表话题
     *
     * @param session
     * @param topicPo
     * @return
     */
    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public ResultVo addTopic(HttpSession session, @RequestBody TopicPo topicPo) {
//        session.setAttribute("userId", "001");
        topicPo.setUserId(session.getAttribute("userId").toString());
        if (topicService.addOneTopic(topicPo) != 0) {
            return ResultUtils.success("添加话题成功.");
        } else {
            return ResultUtils.fail("添加话题失败.");
        }
    }

    /**
     * 话题点赞
     *
     * @param topicId
     * @return
     */
    @RequestMapping(value = "/addTopicPraise", method = RequestMethod.POST)
    public ResultVo addTopicPraise(String topicId) {
        int addToTopicPraise = topicService.addToTopicPraise(topicId);
        if (addToTopicPraise != 1) {
            return ResultUtils.success("话题点赞成功.");
        } else {
            return ResultUtils.fail("话题点赞失败.");
        }
    }

    /**
     * 查询所有话题
     *
     * @return
     */

    @RequestMapping(value = "/selectAllTopics", method = RequestMethod.GET)
    public ResultVo<TopicsVo> selectAllTopic() {
        ResultVo resultVo = new ResultVo();
        List<TopicsVo> list;
        try {
            list = topicService.selectAllTopics();
        } catch (Exception e) {
            logger.error("----------------话题查询出错------------------");
            return ResultUtils.fail("话题查找失败。");
        }
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(list);
        return resultVo;

    }

    /**
     * 查询话题详情页面
     */
    @RequestMapping(value = "/showTopicDetails", method = RequestMethod.POST)
    public ResultVo<TopicDetails> showTopicDetails(String topicId) {
        ResultVo resultVo = new ResultVo();
        TopicDetails topicDetails;
        try {
            topicDetails = topicService.TopicDetails(topicId);
            resultVo.setData(topicDetails);
            resultVo.setCode(ResultEnum.SUCCESS.getCode());
            resultVo.setMsg(ResultEnum.SUCCESS.getMsg());

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultUtils.fail("话题详情页面查询失败.");
        }
        return resultVo;
    }

}
