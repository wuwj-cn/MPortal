package com.mplus.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mplus.core.repository.BaseRepositoryImpl;

@Configuration
@EnableJpaRepositories(basePackages = "com.mplus.**.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaConfiguration {

}
