package com.mql.manage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mql.manage.common.domain.CommonResult;
import com.mql.manage.service.UserService;


@RestController
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/test")
	public CommonResult test(){
		return CommonResult.newSuccessResult("操作成功", userService.queryUserAll());
	}
	
}
