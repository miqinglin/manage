package com.mql.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mql.manage.dao.UserDao;
import com.mql.manage.entity.User;
import com.mql.manage.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserDao userDao;
	
	@Override
	public List<User> queryUserAll() {
		
		return userDao.queryAll();
	}

	@Override
	public int insertUser(User user) {
		user.setStatus("1");
		logger.info("用户注册：req:{}", JSON.toJSONString(user));
		return userDao.insert(user);
	}

	@Override
	public User login(User user) {
		
		return userDao.queryToLogin(user);
	}
	
	
}
