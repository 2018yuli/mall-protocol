package com.ydual.mall.order.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 测试activeMQ消息发送
 * @author l8989
 *
 */
public class TopicSender {

	public static void main(String[] args) throws InterruptedException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"orderAdmin" , "tian", "tcp://47.101.11.182:61616");
		
		Connection connection = null;
		Session session = null;
		try {
			connection = connectionFactory.createConnection();
			// 连接 activeMQ
			connection.start();
			// 连接 Session
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 消息“目的地”
			Destination destination = session.createTopic("test-topic");
			// 消息“生产者”
			MessageProducer producer = session.createProducer(destination);
			for (int i = 0 ; i < 3 ; i++) {
				TextMessage message = session.createTextMessage("Message--" + i);
				Thread.sleep(1000);
				// 通过生产者发出消息
				producer.send(message);
			}
			// 提交
			session.commit();
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
