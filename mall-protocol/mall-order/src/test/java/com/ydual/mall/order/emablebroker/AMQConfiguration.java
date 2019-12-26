package com.ydual.mall.order.emablebroker;

import java.util.ArrayList;
import java.util.List;

import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;
import org.springframework.context.annotation.Bean;

/**
 * JMS 相关配置
 * @author l8989
 *
 */
public class AMQConfiguration{
	
	
    @Bean(initMethod = "start", destroyMethod = "stop")
    public BrokerService brokerService(SimpleAuthenticationPlugin simpleAuthPlugin) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName("orderBroker");
        brokerService.setPersistent(false);
        //brokerService.setUseJmx(false);
        //brokerService.setUseShutdownHook(false);
        brokerService.addConnector("tcp://localhost:61616");
        //brokerService.setTransportConnectorURIs(new String[] {"tcp://localhost:61618"});
        // auth
        brokerService.setPlugins(new BrokerPlugin[] {simpleAuthPlugin});
        return brokerService;
    }
	
    @Bean(name = "admins")
    public AuthenticationUser admins() {
    	return new AuthenticationUser("orderAdmin", "tian", "admins,publisher,consumers");
    }
    @Bean(name="publishers")
    public AuthenticationUser publishers() {
    	return new AuthenticationUser("publisher", "password", "publisher,consumers");
    }
    @Bean(name="consumers")
    public AuthenticationUser consumers() {
    	return new AuthenticationUser("consumer", "password", "consumers");
    }
    @Bean(name="guests")
    public AuthenticationUser guests() {
    	return new AuthenticationUser("guest", "password", "guests");
    }
    
    @Bean
    public SimpleAuthenticationPlugin simpleAuthPlugin(AuthenticationUser admins, AuthenticationUser publishers, AuthenticationUser consumers, AuthenticationUser guests) {
    	SimpleAuthenticationPlugin auth = new SimpleAuthenticationPlugin();
    	List<AuthenticationUser> users = new ArrayList<AuthenticationUser>();
    	users.add(admins);
    	users.add(publishers);
    	users.add(consumers);
    	users.add(guests);
    	auth.setUsers(users);
    	return auth;
    }
	
}