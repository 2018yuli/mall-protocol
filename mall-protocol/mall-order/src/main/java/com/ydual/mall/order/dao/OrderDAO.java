package com.ydual.mall.order.dao;

import org.springframework.stereotype.Repository;

import com.ydual.mall.common.dao.BaseDAO;
import com.ydual.mall.order.vo.OrderModel;
import com.ydual.mall.order.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
