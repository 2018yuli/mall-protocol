package com.ydual.mall.common.service;
import java.util.List;

import com.ydual.mall.common.dao.BaseDAO;
import com.ydual.mall.common.pageutil.Page;
import com.ydual.mall.common.vo.BaseModel;

public class BaseService<M, QM extends BaseModel> implements IBaseService<M,QM> {
	private BaseDAO dao = null;
	public void setDAO(BaseDAO dao){
		this.dao = dao;
	}
	public void create(M m) {
		dao.create(m);
	}

	public void update(M m) {
		dao.update(m);
	}

	public void delete(int uuid) {
		dao.delete(uuid);
	}

	public M getByUuid(int uuid) {
		return (M)dao.getByUuid(uuid);
	}

	public Page<M> getByConditionPage(QM qm) {
		List list = dao.getByConditionPage(qm);
		// 为了能拿到 page,需要安排一个BaseModel
		qm.getPage().setResult(list);
		
		return qm.getPage();
	}
}
