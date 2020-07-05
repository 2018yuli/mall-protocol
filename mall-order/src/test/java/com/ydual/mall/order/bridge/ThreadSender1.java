package com.ydual.mall.order.bridge;

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
 * 
 * @author l8989
 *
 */
public class ThreadSender1 {

	public static void main(String[] args) throws InterruptedException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("clusterBroker", "tian",
				"tcp://47.101.11.182:61617");
		
		ThreadSender1 tsoutter = new ThreadSender1();
		for (int i = 0; i < 1; i++) {
			ThreadSender1.ThreadSender ts = tsoutter.new ThreadSender(connectionFactory);
			ts.start();
			Thread.sleep(500);
		}
	}

	class ThreadSender extends Thread {

		private ConnectionFactory connectionFactory;
		
		public ThreadSender(ConnectionFactory connectionFactory) {
			this.connectionFactory = connectionFactory;
		}
		@Override
		public void run() {
			Connection connection = null;
			Session session = null;
			try {
				connection = connectionFactory.createConnection();
				// 连接 activeMQ
				connection.start();
				// 连接 Session
				session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
				// 消息“目的地”
				Destination destination = session.createQueue("sausage-factory");
				// 消息“生产者”
				MessageProducer producer = session.createProducer(destination);
				for (int i = 0 ; i < 4 ; i++) {
					TextMessage message = session.createTextMessage("Message--11" + i);
					Thread.sleep(1000);
					// 通过生产者发出消息
					producer.send(message);
				}
				// 提交
				session.commit();
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
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
}
