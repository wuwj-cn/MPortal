package com.mplus.MPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mplus.MPortal.model.Menu;
import com.mplus.core.repository.BaseRepository;

public interface MenuRepository extends BaseRepository<Menu, String>{

	@Query("from Menu where parent.code = :parentCode")
	List<Menu> findChildren(@Param("parentCode") String parentCode);
}
