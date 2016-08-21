package com.mplus.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.mplus.core.repository.BaseRepository;

//@Service
//@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired private BaseRepository<T, ID> baseRepository;
	
	/**
	 * 这里必须使用setter注入，如果使用@Autowired注入会导致异常
	 */
//	public void setBaseRepository(BaseRepository<T, ID> baseRepository) {
//		this.baseRepository = baseRepository;
//	}

	@Override
	public <S extends T> S save(S entity) {
		return baseRepository.save(entity);
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		return baseRepository.save(entities);
	}

	@Override
	public T findOne(ID id) {
		return baseRepository.findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return baseRepository.exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return baseRepository.findAll(ids);
	}

	@Override
	public long count() {
		return baseRepository.count();
	}

	@Override
	public void delete(ID id) {
		baseRepository.delete(id);
	}

	@Override
	public void delete(T entity) {
		baseRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		baseRepository.delete(entities);
	}

	@Override
	public void deleteAll() {
		baseRepository.deleteAll();
	}

}
