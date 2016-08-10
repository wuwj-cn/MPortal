package com.mplus.MPortal.dao;

import org.springframework.data.repository.CrudRepository;

import com.mplus.MPortal.model.User;

public interface UserDao extends CrudRepository<User, String> {

  public User findByUsername(String username);
  
}