package com.ydual.mall.mall.cartmgr.dao;

import org.springframework.stereotype.Repository;
import com.sishuok.architecture1.common.dao.BaseDAO;

import com.ydual.mall.mall.cartmgr.vo.CartModel;
import com.ydual.mall.mall.cartmgr.vo.CartQueryModel;

@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel>{
	
}
