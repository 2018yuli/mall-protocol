package com.ydual.mall.order.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ydual.mall.common.service.BaseService;
import com.ydual.mall.order.dao.OrderDetailDAO;
import com.ydual.mall.order.vo.OrderDetailModel;
import com.ydual.mall.order.vo.OrderDetailQueryModel;

@Service
@Transactional
public class OrderDetailService extends BaseService<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}