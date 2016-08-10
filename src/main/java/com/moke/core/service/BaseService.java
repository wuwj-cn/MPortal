package com.moke.core.service;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {
    
	<S extends T> S save(S entity);

	<S extends T> Iterable<S> save(Iterable<S> entities);

	T findOne(ID id);

	boolean exists(ID id);

	Iterable<T> findAll();

	Iterable<T> findAll(Iterable<ID> ids);

	long count();

	void delete(ID id);

	void delete(T entity);

	void delete(Iterable<? extends T> entities);

	void deleteAll();

}
