package com.ydual.mall.mall.ordermgr.dao;

import org.springframework.stereotype.Repository;
import com.sishuok.architecture1.common.dao.BaseDAO;

import com.ydual.mall.mall.ordermgr.vo.OrderModel;
import com.ydual.mall.mall.ordermgr.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
