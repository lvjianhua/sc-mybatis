package org.sc.service.myb.util.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 同时使用两种模式
 * 
 * JMS配置
 */
@Configuration
public class JmsConfig {
	public final static String TOPIC = "topic-test";
	public final static String QUEUE = "queue-test";

	@Bean
	public Queue queue() {
		return new ActiveMQQueue(QUEUE);
	}

	@Bean
	public Topic topic() {
		return new ActiveMQTopic(TOPIC);
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(
			ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerQueue(
			ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

}
