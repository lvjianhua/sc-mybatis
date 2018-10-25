package org.sc.service.myb.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sc.service.myb.MybatisApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
 
/**
 * @modified By
 * @description
 * @date Created in 2018/7/31 17:19
 */
@SpringBootTest(classes = MybatisApplication.class)
@RunWith(SpringRunner.class)
public class ActiveMqTest {
 
 /*   *//**
     * 消息生产者
     *//*
    @Autowired
    private Producer producer;
 
    *//**
     * 及时消息队列测试
     *//*
    @Test
    public void test(){
        MessageModel messageModel = MessageModel.builder()
                .message("测试消息")
                .titile("消息000")
                .build();
        // 发送消息
        producer.send(Producer.DEFAULT_QUEUE, messageModel);
    }
 
    *//**
     * 延时消息队列测试
     *//*
    @Test
    public void test2(){
        for (int i=0;i< 20;i++){
            MessageModel messageModel = MessageModel.builder()
                    .titile("延迟10秒执行")
                    .message("测试消息" + i)
                    .build();
            // 发送延迟消息
            producer.delaySend(Producer.DEFAULT_QUEUE, messageModel, 10000L);
        }
        try {
            // 休眠100秒，等等消息执行
            Thread.currentThread().sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
