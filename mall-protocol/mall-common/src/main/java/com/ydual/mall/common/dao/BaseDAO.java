package com.ydual.mall.common.dao;

import java.util.List;

/**
 * 基类
 * @param <M>
 * @param <QM>
 */
public interface BaseDAO<M,QM>{
	
	public void create(M m);
	public void update(M m);
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	public List<M> getByConditionPage(QM qm);
}
