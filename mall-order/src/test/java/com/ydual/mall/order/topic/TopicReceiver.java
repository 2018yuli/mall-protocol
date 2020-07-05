package com.ydual.mall.order.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 测试activeMQ消息接收
 * @author l8989
 *
 */
public class TopicReceiver {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"orderAdmin" , "tian", "tcp://47.101.11.182:61616");
		
		Connection connection = null;
		Session session = null;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			// 消息“会话”
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 消息“目的地”
			Destination destination = session.createTopic("test-topic");
			// 消息“消费者”
			MessageConsumer consumer = session.createConsumer(destination);
			Message message = consumer.receive();
			while (message != null) {
				TextMessage textMessage = (TextMessage) message; 
				System.out.println("收到消息：" + textMessage.getText());
				message = consumer.receive(1000L);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (connection != null)
					connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}
	}
}
