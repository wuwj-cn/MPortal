package com.mplus.MPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mplus.MPortal.model.Menu;

public interface MenuDao extends JpaRepository<Menu, String> {

}
