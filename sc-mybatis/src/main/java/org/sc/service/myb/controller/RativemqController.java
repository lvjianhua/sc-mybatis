package org.sc.service.myb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.sc.service.myb.util.activemq.ProducerService;
import org.sc.service.myb.util.activemq.ProducerTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Api(value ="rativemq",description = "消息中间件rativemq")
@RestController
@RequestMapping("/sc-mybatis/student")
@Slf4j
public class RativemqController {
    /**
     * 消息生产者
     */
    @Autowired
    private ProducerService producer;
    
    @Autowired
    private ProducerTopicService producerTopicService;
    
    @ApiOperation("发送即时处理消息【队列模式】")
    @RequestMapping(value="/sendMessage",method=RequestMethod.POST)
    public String sendMessage(String message){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("发送消息：(" + message+")时间："+format.format(new Date()));
    	producer.send(message);
        return "1";
    }
    
    @ApiOperation("发送延时处理消息【队列模式】")
    @RequestMapping(value="/sendDelayMessage",method=RequestMethod.POST)
    public String sendDelayMessage(String message,Long time){
        for (int i=0;i< 20;i++){
        	// 发送延迟消息
            producer.delaySend(message+i, time);
        }
        return "1";
    }
    
    @ApiOperation("发送即时处理消息【主题模式】")
    @RequestMapping(value="/sendTopicMessage",method=RequestMethod.POST)
    public String sendTopicMessage(String message){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("发送消息topic：(" + message+")时间："+format.format(new Date()));
		producerTopicService.sendMessage(message);
        return "1";
    }
    
}
