package com.mql.manage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.mql.manage.entity.User;
import tk.mybatis.mapper.common.Mapper;


public interface UserDao extends Mapper<User>{
	
	@Select("select * from t_user")
	List<User> queryAll();
	
//	@Select("select * from t_user where login_name=#{loginName} and login_pwd=#{loginPwd}")
	User queryToLogin(User user);
	
}
