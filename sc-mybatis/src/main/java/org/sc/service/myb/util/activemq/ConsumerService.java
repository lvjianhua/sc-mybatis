package org.sc.service.myb.util.activemq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sc.service.myb.util.activemq.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消息的消费者【队列模式】
 */
@Service("consumerService")
public class ConsumerService {
	@JmsListener(destination = JmsConfig.QUEUE, containerFactory = "jmsListenerContainerQueue")
	public void receiveQueue(String text) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("收到消息：(" + text+")时间："+format.format(new Date()));
	}

}
