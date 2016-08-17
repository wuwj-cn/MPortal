package com.mplus.MPortal.repository;

import com.mplus.MPortal.model.User;
import com.mplus.core.repository.BaseRepository;

public interface UserRepository extends BaseRepository<User, String> {

	public User findByUsername(String username);
}