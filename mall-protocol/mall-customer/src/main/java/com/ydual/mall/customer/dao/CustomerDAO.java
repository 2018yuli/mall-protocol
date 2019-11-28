package com.ydual.mall.customer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ydual.mall.customer.vo.CustomerModel;
import com.ydual.mall.customer.vo.CustomerQueryModel;

/**
 * @author l8989
 */
@Repository
public interface CustomerDAO {

	public void create(CustomerModel m);
	public void update(CustomerModel m);
	public void delete(int uuid);
	
	public CustomerModel getByUuid(int uuid);
	public List<CustomerModel> getByConditionPage(CustomerQueryModel qm);
}
