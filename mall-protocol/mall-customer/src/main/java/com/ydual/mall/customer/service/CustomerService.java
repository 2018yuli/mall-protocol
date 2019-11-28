package com.ydual.mall.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ydual.mall.common.service.BaseService;
import com.ydual.mall.customer.dao.CustomerMapper;
import com.ydual.mall.customer.vo.CustomerModel;
import com.ydual.mall.customer.vo.CustomerQueryModel;

@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> implements ICustomerService{
	
	private CustomerMapper dao = null;

	@Autowired
	private void setDao(CustomerMapper dao){
		this.dao = dao;
		// 代理只能代理方法
		super.setDAO(dao);
	}
	
	public CustomerModel getByCustomerId(String customerId) {
		return dao.getByCustomerId(customerId);
	}
	
}
