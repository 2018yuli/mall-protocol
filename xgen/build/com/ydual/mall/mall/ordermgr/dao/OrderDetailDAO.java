package com.ydual.mall.mall.ordermgr.dao;

import org.springframework.stereotype.Repository;
import com.sishuok.architecture1.common.dao.BaseDAO;

import com.ydual.mall.mall.ordermgr.vo.OrderDetailModel;
import com.ydual.mall.mall.ordermgr.vo.OrderDetailQueryModel;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel>{
	
}
