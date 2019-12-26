package com.ydual.mall.order.emablebroker;

import java.util.ArrayList;
import java.util.List;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;

/**
 * 嵌入broker测试
 * @author l8989
 *
 */
public class BrokerTest {

	public static void main(String[] args) {
		brokerService();
	}
	
	/**
	 * 在需要的时候启动broker,进行消息的发送，接收
	 */
	public static void brokerService() {
		BrokerService broker = new BrokerService();
		broker.setUseJmx(true);
		try {
			broker.addConnector("tcp://localhost:61616");
			AuthenticationUser admin = new AuthenticationUser("orderAdmin","tian","admin");
			List<AuthenticationUser> users = new ArrayList<AuthenticationUser>();
			users.add(admin);
			broker.setPlugins(new BrokerPlugin[] {
					new SimpleAuthenticationPlugin(users)
			});
			broker.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void brokerFactory() {
		String uri = "properties:broker.properties";
		// userJmx=true
		// persistent=false
		// brokerName=Cheese
		try {
			BrokerService brokerService = BrokerFactory.createBroker(uri);
			brokerService.addConnector("tcp://localhost:61616");
			brokerService.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
