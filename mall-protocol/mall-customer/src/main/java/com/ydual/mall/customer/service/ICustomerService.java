package com.ydual.mall.customer.service;


import com.ydual.mall.common.service.IBaseService;
import com.ydual.mall.customer.vo.CustomerModel;
import com.ydual.mall.customer.vo.CustomerQueryModel;

public interface ICustomerService extends IBaseService<CustomerModel, CustomerQueryModel> {
	
	public CustomerModel getByCustomerId(String customerId);
}
