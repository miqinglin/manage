package com.mql.manage.common.domain;

import com.mql.manage.common.enums.RespManageCode;

public class CommonResult {

	private String code;

	private String message;

	private Object data;

	private CommonResult(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private CommonResult(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static CommonResult newSuccessResult(String message) {
		return new CommonResult(RespManageCode.SUCCESS.getCode(), message);
	}

	public static CommonResult newSuccessResult(String message, Object data) {
		return new CommonResult(RespManageCode.SUCCESS.getCode(), message, data);
	}

	public static CommonResult newFailedResult(String message, Object data) {
		return new CommonResult(RespManageCode.FAILED.getCode(), message, data);
	}
	
	public static CommonResult newFailedResult(String message) {
		return new CommonResult(RespManageCode.FAILED.getCode(), message);
	}
	
	public static CommonResult newErrorResult(String message, Object data) {
		return new CommonResult(RespManageCode.SYSTEM_ERROR.getCode(), message, data);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
