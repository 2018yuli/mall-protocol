package com.ydual.mall.goodsmgr.dao;

import org.springframework.stereotype.Repository;

import com.ydual.mall.common.dao.BaseDAO;
import com.ydual.mall.goodsmgr.vo.GoodsModel;
import com.ydual.mall.goodsmgr.vo.GoodsQueryModel;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel>{
	
}
