package com.ydual.mall.goodsmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ydual.mall.common.service.BaseService;
import com.ydual.mall.goodsmgr.dao.GoodsDAO;
import com.ydual.mall.goodsmgr.vo.GoodsModel;
import com.ydual.mall.goodsmgr.vo.GoodsQueryModel;

@Service
@Transactional
public class GoodsService extends BaseService<GoodsModel,GoodsQueryModel> implements IGoodsService{
	private GoodsDAO dao = null;
	@Autowired
	private void setDao(GoodsDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}