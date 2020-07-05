package com.ydual.mall.order.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Service;

import com.ydual.mall.order.entity.NewBeeMallOrder;

@Service
public class AMQMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			if (objectMessage.getObject() instanceof NewBeeMallOrder) {
				NewBeeMallOrder newUserMessage = (NewBeeMallOrder) objectMessage.getObject();
				System.out.println(newUserMessage.getOrderNo());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
