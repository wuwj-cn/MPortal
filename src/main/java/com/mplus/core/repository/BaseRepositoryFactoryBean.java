package com.mplus.core.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class BaseRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
		return new MyRepositoryFactory(em);
	}

	private static class MyRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

		private final EntityManager em;

		public MyRepositoryFactory(EntityManager em) {
			super(em);
			this.em = em;
		}


		@Override
		protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
				RepositoryInformation information, EntityManager entityManager) {
			return super.getTargetRepository(information, entityManager);
		}


		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return BaseRepositoryImpl.class;
		}
	}
}
