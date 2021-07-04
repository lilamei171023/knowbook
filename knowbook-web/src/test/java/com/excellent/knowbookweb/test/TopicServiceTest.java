package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.model.pojo.Topic;
import com.excellent.knowbookcore.KnowbookCoreApplication;
import com.excellent.knowbookcore.service.TopicService;
import com.excellent.knowbookweb.KnowbookWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @User: Rowena
 * @Date: 2018/8/11
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KnowbookWebApplication.class)
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void saveTopic() {
        List<Topic> topicList=topicService.selectAllTopic();
        for (Topic topic: topicList) {
            topicService.saveTopic(topic);
        }
    }
}