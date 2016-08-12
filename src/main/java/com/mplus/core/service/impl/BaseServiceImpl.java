package com.mplus.core.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mplus.core.dao.BaseDao;
import com.mplus.core.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	private BaseDao<T, ID> baseDao;
	
	@Override
	public <S extends T> S save(S entity) {
		return baseDao.save(entity);
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		return baseDao.save(entities);
	}

	@Override
	public T findOne(ID id) {
		return baseDao.findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return baseDao.exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return baseDao.findAll(ids);
	}

	@Override
	public long count() {
		return baseDao.count();
	}

	@Override
	public void delete(ID id) {
		baseDao.delete(id);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		baseDao.delete(entities);
	}

	@Override
	public void deleteAll() {
		baseDao.deleteAll();
	}

}
