package com.ydual.mall.order.bridge;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 测试多线程activeMQ消息接收
 * @author l8989
 *
 */
public class ThreadReceiver1 {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"clusterBroker" , "tian", "tcp://47.101.11.182:61617");
		
		ThreadReceiver1 troutter = new ThreadReceiver1();
		for (int i = 0 ; i < 30 ; i++) {
			ThreadReceive tr = troutter.new ThreadReceive(connectionFactory);
			tr.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	class ThreadReceive extends Thread {
		
		private ConnectionFactory connectionFactory;
		
		public ThreadReceive(ConnectionFactory connectionFactory) {
			this.connectionFactory = connectionFactory;
		}
		
		@Override
		public void run() {
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
					Thread.sleep(1000);
					System.out.println("收到消息：" + message.getText());
				}
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
