package com.ydual.mall.mall.storemgr.dao;

import org.springframework.stereotype.Repository;
import com.sishuok.architecture1.common.dao.BaseDAO;

import com.ydual.mall.mall.storemgr.vo.StoreModel;
import com.ydual.mall.mall.storemgr.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	
}
