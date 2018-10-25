package org.sc.service.myb.util.activemq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sc.service.myb.util.activemq.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 
 * 消息的消费者
 */
@Service("consumerTopic2Service")
public class ConsumerTopic2Service {
	@JmsListener(destination = JmsConfig.TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void onTopicMessage(String msg) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("consumerTopic2Service接收到topic消息(" + msg+")时间："+format.format(new Date()));
	}
}
