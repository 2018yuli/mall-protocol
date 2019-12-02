package com.ydual.mall.mall.cartmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sishuok.architecture1.common.service.BaseService;

import com.ydual.mall.mall.cartmgr.dao.CartDAO;
import com.ydual.mall.mall.cartmgr.vo.CartModel;
import com.ydual.mall.mall.cartmgr.vo.CartQueryModel;

@Service
@Transactional
public class CartService extends BaseService<CartModel,CartQueryModel> implements ICartService{
	private CartDAO dao = null;
	@Autowired
	private void setDao(CartDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}