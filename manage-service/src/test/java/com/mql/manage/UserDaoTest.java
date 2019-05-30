package com.mql.manage;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.mql.manage.dao.UserDao;
import com.mql.manage.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-dao.xml"})
public class UserDaoTest {
	@Resource
	private UserDao UserDao;
	
	@Test
	public void queryUserAll(){
		List<User> users = UserDao.queryAll();
		System.out.println(JSON.toJSONString(users));
	}
	
	@Test
	public void queryById(){
		User user = UserDao.selectByPrimaryKey(1);
		System.out.println(JSON.toJSONString(user));
	}
	
}
