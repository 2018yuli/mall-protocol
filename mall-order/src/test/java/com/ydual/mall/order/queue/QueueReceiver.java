package com.ydual.mall.order.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 测试activeMQ消息接收
 * @author l8989
 *
 */
public class QueueReceiver {

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
			Destination destination = session.createQueue("jms.queue.test-queue2");
			// 消息“消费者”
			MessageConsumer consumer = session.createConsumer(destination);
			int i = 0;
			while (i < 3) {
				i++;
				TextMessage message = (TextMessage) consumer.receive();
				// 通知activeMQ消息收到了
				session.commit();
				System.out.println("收到消息：" + message.getText());
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
