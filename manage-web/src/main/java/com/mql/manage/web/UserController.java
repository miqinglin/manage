package com.mql.manage.web;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mql.manage.common.domain.CommonResult;
import com.mql.manage.entity.User;
import com.mql.manage.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@PostMapping("/doRegister")
	public CommonResult register(@RequestBody User user){
		if(StringUtils.isEmpty(user.getLoginName()))
			return CommonResult.newFailedResult("登录名不能为空");
		if(StringUtils.isEmpty(user.getLoginPwd())){
			return CommonResult.newFailedResult("登录密码能为空");
		}
		int result = userService.insertUser(user);
		if(result > 0)
			return CommonResult.newSuccessResult("账号注册成功");
		else
			return CommonResult.newFailedResult("注册失败");
	}
	
	@ResponseBody
	@PostMapping("/doLogin")
	public CommonResult doLogin(User user, HttpSession session){
		User dbUser = userService.login(user);
		if(null != dbUser){
			session.setAttribute("loginUser", dbUser);
			return CommonResult.newSuccessResult("登录成功");
		}else{
			return CommonResult.newFailedResult("登录失败");
		}
	}
	
	@GetMapping("/regist")
	public String gotoRegPage(){
		
		return "user/regist";
	}
	
}
