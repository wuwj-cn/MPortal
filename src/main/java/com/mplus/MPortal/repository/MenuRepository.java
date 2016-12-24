package com.mplus.MPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mplus.MPortal.model.Menu;
import com.mplus.core.repository.BaseRepository;

public interface MenuRepository extends BaseRepository<Menu, String>{

	@Query("from Menu where parent.id = :parentId")
	List<Menu> findChildren(@Param("parentId") String parentId);
}
