package com.ydual.mall.order.emablebroker;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

/**
 * 嵌入broker测试
 * @author l8989
 *
 */
public class BrokerTest {

	public static void main(String[] args) {
		
		
	}
	
	/**
	 * 在需要的时候启动broker,进行消息的发送，接收
	 */
	public static void brokerService() {
		BrokerService broker = new BrokerService();
		broker.setUseJmx(true);
		try {
			broker.addConnector("tcp://localhost:61616");
			broker.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void brokerFactory() {
		String uri = "properties:broker.properties";
		try {
			BrokerService brokerService = BrokerFactory.createBroker(uri);
			brokerService.addConnector("tcp://localhost:61616");
			brokerService.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
