package com.ydual.mall.order;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/**
 * JMS 相关配置
 * @author l8989
 *
 */
@Configuration
@EnableJms
@ComponentScan("com.ydual.mall.order.jms")
public class JmsConfiguration{
	
	/**
	 * 通过连接池创建Broker
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
        return new com.ydual.mall.order.jms.listener.AMQMessageListener();
    }
    
}