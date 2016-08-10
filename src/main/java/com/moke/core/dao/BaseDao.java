package com.moke.core.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
