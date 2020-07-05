package com.ydual.mall.order.persistenttopic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 测试activeMQ消息接收
 * @author l8989
 *
 */
public class PersistentTopicReceiver {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"orderAdmin" , "tian", "tcp://47.101.11.182:61616");
		
		Connection connection = null;
		Session session = null;
		try {
			connection = connectionFactory.createConnection();
			// 消息“注册订阅者”
			connection.setClientID("testClient");
			// 消息“会话”
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 消息“目的地”
			Topic destination = session.createTopic("test-topic");
			// 消息“订阅者”
			TopicSubscriber ts = session.createDurableSubscriber(destination, "T1");
			connection.start();
			Message message = ts.receive();
			while (message != null) {
				TextMessage textMessage = (TextMessage) message; 
				session.commit();
				System.out.println("收到消息：" + textMessage.getText());
				message = ts.receive(1000L);
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
