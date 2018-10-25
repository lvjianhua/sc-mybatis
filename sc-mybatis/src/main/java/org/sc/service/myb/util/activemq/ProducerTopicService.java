package org.sc.service.myb.util.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * 消息生产者【主题模式】
 * 一个消息可被多个消费者消费
 * 发送消息
 */
@Service("producerTopicService")
public class ProducerTopicService {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Queue queue;
	@Autowired
	private Topic topic;

	public void sendMessage(String message) {
		//jmsMessagingTemplate.convertAndSend(queue, message);
		jmsMessagingTemplate.convertAndSend(topic, message);
	}

}