package com.ydual.mall.common.service;


import com.ydual.mall.common.pageutil.Page;
import com.ydual.mall.common.vo.BaseModel;

public interface IBaseService<M,QM extends BaseModel> {
	public void create(M m);
	public void update(M m);
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	public Page<M> getByConditionPage(QM qm);
}
