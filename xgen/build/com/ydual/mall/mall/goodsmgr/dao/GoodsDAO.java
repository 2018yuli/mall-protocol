package com.ydual.mall.mall.goodsmgr.dao;

import org.springframework.stereotype.Repository;
import com.sishuok.architecture1.common.dao.BaseDAO;

import com.ydual.mall.mall.goodsmgr.vo.GoodsModel;
import com.ydual.mall.mall.goodsmgr.vo.GoodsQueryModel;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel>{
	
}
