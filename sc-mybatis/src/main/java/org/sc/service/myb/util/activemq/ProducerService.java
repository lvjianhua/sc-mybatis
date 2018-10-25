package org.sc.service.myb.util.activemq;

import org.apache.activemq.ScheduledMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.sc.service.myb.util.activemq.config.JmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
 

import javax.jms.*;

/**
 * 消息生产者【队列模式】
 * 一个消息只能被一个消费者消费
 * 发送消息
 */
@Service("producerService")
public class ProducerService {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;


    /**
     * 发送消息
     * @param destination destination是发送到的队列
     * @param message message是待发送的消息
     */
    public void send(String message){
    	Destination destination = new ActiveMQQueue(JmsConfig.QUEUE);
    	jmsMessagingTemplate.convertAndSend(destination, message);
	}
	
    /**
     * 延时发送
     * @param destination 发送的队列
     * @param data 发送的消息
     * @param time 延迟时间
     */
    public void delaySend(String data, Long time){
    	Destination destination = new ActiveMQQueue(JmsConfig.QUEUE);
    	Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        // 获取连接工厂
        ConnectionFactory connectionFactory = jmsMessagingTemplate.getConnectionFactory();
        try {
            // 获取连接
            connection = connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 获取session，true开启事务，false关闭事务
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            producer = session.createProducer(destination);
            producer.setDeliveryMode(JmsProperties.DeliveryMode.PERSISTENT.getValue());
            ObjectMessage message = session.createObjectMessage(data);
            //设置延迟时间
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
            // 发送消息
            producer.send(message);
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (producer != null){
                    producer.close();
                }
                if (session != null){
                    session.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}