package com.ydual.mall.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ydual.mall.common.pageutil.Page;
import com.ydual.mall.customer.service.ICustomerService;
import com.ydual.mall.customer.vo.CustomerModel;
import com.ydual.mall.customer.vo.CustomerQueryModel;

//@Service
public class Client {

	@Autowired
	private ICustomerService customerService;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
		Client c = (Client) ctx.getBean("client");
		
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("c2");
		cm.setPwd("c2");
		cm.setRegisterTime("111");
		cm.setShowName("c2");
		cm.setTrueName("李四");
		
		c.customerService.create(cm);
		// 如果该类添加事物， c.customerService，会由于代理的关系而拿不到
		Page<CustomerModel> list = c.getCustomerService().getByConditionPage(new CustomerQueryModel());
		System.out.println(list.getTotalCount());
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}
	
	
}
