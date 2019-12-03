package com.ydual.mall.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ydual.mall.common.service.BaseService;
import com.ydual.mall.order.dao.OrderDAO;
import com.ydual.mall.order.vo.OrderModel;
import com.ydual.mall.order.vo.OrderQueryModel;

@Service
@Transactional
public class OrderService extends BaseService<OrderModel,OrderQueryModel> implements IOrderService{
	private OrderDAO dao = null;
	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}