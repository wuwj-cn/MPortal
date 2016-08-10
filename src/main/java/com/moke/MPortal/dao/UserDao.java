package com.moke.MPortal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moke.MPortal.model.User;

@Repository
//@Transactional
public interface UserDao extends CrudRepository<User, String> {

  public User findByUsername(String username);
  
}