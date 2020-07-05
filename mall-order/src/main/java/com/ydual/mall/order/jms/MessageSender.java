package com.ydual.mall.order.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.ydual.mall.order.entity.NewBeeMallOrder;

@Service
public class MessageSender {

    private JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendOrder(NewBeeMallOrder message){
        jmsTemplate.convertAndSend(message);
    }
}