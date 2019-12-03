package com.ydual.mall.stock.dao;

import org.springframework.stereotype.Repository;

import com.ydual.mall.common.dao.BaseDAO;
import com.ydual.mall.stock.vo.StoreModel;
import com.ydual.mall.stock.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	
}
