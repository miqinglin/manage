package com.mql.manage.service;

import java.util.List;

import com.mql.manage.entity.User;

public interface UserService {
	
	List<User> queryUserAll();
	
	int insertUser(User user);
	
	User login(User user);
}
