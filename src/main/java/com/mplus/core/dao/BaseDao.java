package com.mplus.core.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface BaseDao<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
