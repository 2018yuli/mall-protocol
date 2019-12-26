package com.ydual.mall.order;

import java.util.ArrayList;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.ydual.mall.order.jms.listener.AMQMessageListener;

/**
 * JMS 相关配置
 * @author l8989
 *
 */
@Configuration
@EnableJms
@ComponentScan("com.ydual.mall.order.jms")
public class JmsConfiguration{
	
	
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public BrokerService brokerService(SimpleAuthenticationPlugin simpleAuthPlugin) throws Exception {
//        BrokerService brokerService = new BrokerService();
//        brokerService.setBrokerName("orderBroker");
//        brokerService.setPersistent(false);
//        //brokerService.setUseJmx(false);
//        //brokerService.setUseShutdownHook(false);
//        brokerService.addConnector("tcp://localhost:61616");
//        //brokerService.setTransportConnectorURIs(new String[] {"tcp://localhost:61618"});
//        // auth
//        brokerService.setPlugins(new BrokerPlugin[] {simpleAuthPlugin});
//        return brokerService;
//    }
	
	/**
	 * 通过连接池创建Broker，不再需要BrokerService
	 * @param connectionFactory
	 * @return
	 */
    @Bean(destroyMethod = "stop")
    public PooledConnectionFactory jmsFactory(ConnectionFactory connectionFactory) {
    	PooledConnectionFactory pool = new PooledConnectionFactory();
    	pool.setConnectionFactory(connectionFactory);
    	pool.setMaxConnections(100);
    	return pool;
    }
    
    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.101.11.182:61616");
        factory.setUserName("orderAdmin");
        factory.setPassword("tian");
        return factory;
    }

    @Bean
    public ActiveMQQueue defaultDestination(){
        return new ActiveMQQueue("order-queue");
    }
    
    @Bean
    public ActiveMQTopic topicDestination() {
    	return new ActiveMQTopic("order-topic");
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQQueue defaultDestination, PooledConnectionFactory jmsFactory, SimpleMessageConverter simpleMessageConverter){
        JmsTemplate jmsTemplate = new JmsTemplate(jmsFactory);
        jmsTemplate.setDefaultDestination(defaultDestination);
        jmsTemplate.setMessageConverter(simpleMessageConverter);
        return jmsTemplate;
    }
    
    @Bean
	public SimpleMessageConverter simpleMessageConverter() {
		return new SimpleMessageConverter();
	}

    @Bean
    public DefaultMessageListenerContainer jmsListenerContainerFactory(ConnectionFactory connectionFactory, ActiveMQTopic topicDestination, MessageListener messageListener){
        DefaultMessageListenerContainer containerFactory = new DefaultMessageListenerContainer();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setDestination(topicDestination);
        containerFactory.setMessageListener(messageListener);
        return containerFactory;
    }

    @Bean
    public MessageListener messageListener(){
        return new AMQMessageListener();
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