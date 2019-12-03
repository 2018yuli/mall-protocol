package com.ydual.mall.stock.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ydual.mall.common.service.BaseService;
import com.ydual.mall.stock.dao.StoreDAO;
import com.ydual.mall.stock.vo.StoreModel;
import com.ydual.mall.stock.vo.StoreQueryModel;

@Service
@Transactional
public class StoreService extends BaseService<StoreModel,StoreQueryModel> implements IStoreService{
	private StoreDAO dao = null;
	@Autowired
	private void setDao(StoreDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}