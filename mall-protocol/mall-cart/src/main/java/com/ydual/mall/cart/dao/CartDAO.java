package com.ydual.mall.cart.dao;

import org.springframework.stereotype.Repository;

import com.ydual.mall.cart.vo.CartModel;
import com.ydual.mall.cart.vo.CartQueryModel;
import com.ydual.mall.common.dao.BaseDAO;

@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel>{
	
}
