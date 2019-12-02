package com.ydual.mall.mall.ordermgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sishuok.architecture1.common.service.BaseService;

import com.ydual.mall.mall.ordermgr.dao.OrderDAO;
import com.ydual.mall.mall.ordermgr.vo.OrderModel;
import com.ydual.mall.mall.ordermgr.vo.OrderQueryModel;

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