package com.mplus.core.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private final EntityManager em;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);
		this.em = em;
	}
	
//	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
//        super(domainClass, entityManager);
//        this.domainClass = domainClass;
//    }
//
//	@Override
//    public boolean support(String modelType) {
//        return domainClass.getName().equals(modelType);
//    }
}
