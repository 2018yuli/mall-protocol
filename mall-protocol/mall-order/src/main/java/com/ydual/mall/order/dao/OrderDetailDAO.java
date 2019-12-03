package com.ydual.mall.order.dao;

import org.springframework.stereotype.Repository;

import com.ydual.mall.common.dao.BaseDAO;
import com.ydual.mall.order.vo.OrderDetailModel;
import com.ydual.mall.order.vo.OrderDetailQueryModel;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel>{
	
}
