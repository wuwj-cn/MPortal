package com.moke.MPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moke.MPortal.model.Menu;

@Repository
public interface MenuDao extends JpaRepository<Menu, String> {

}
