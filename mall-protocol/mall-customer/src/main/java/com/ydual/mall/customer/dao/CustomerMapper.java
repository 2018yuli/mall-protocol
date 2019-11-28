package com.ydual.mall.customer.dao;


import org.springframework.stereotype.Repository;

import com.ydual.mall.common.dao.BaseDAO;
import com.ydual.mall.customer.vo.CustomerModel;
import com.ydual.mall.customer.vo.CustomerQueryModel;

@Repository
public interface CustomerMapper extends BaseDAO<CustomerModel,CustomerQueryModel> {
	public CustomerModel getByCustomerId(String customerId);
}
