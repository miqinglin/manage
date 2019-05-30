package com.mql.manage;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.mql.manage.entity.User;
import com.mql.manage.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=
		{"classpath:spring-context.xml",
		 "classpath*:spring-dao.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void queryUserAll(){
		List<User> users = userService.queryUserAll();
		System.out.println(JSON.toJSONString(users));
	}
}
