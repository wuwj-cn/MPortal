package com.moke.MPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moke.MPortal.dao.UserDao;
import com.moke.MPortal.model.User;
import com.moke.MPortal.service.UserService;
import com.moke.core.service.impl.BaseServiceImpl;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Autowired
	private UserDao userDao;
	
}
