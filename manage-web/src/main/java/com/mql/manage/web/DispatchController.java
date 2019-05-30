package com.mql.manage.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatchController {
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/main")
	public String main(){
		
		return "main";
	}
	
	@GetMapping("/exitLogin")
	public String exitLogin(HttpSession session){
		session.invalidate();
		
		return "redirect:login";
	}
}
