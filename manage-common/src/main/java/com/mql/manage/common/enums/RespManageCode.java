package com.mql.manage.common.enums;

public enum RespManageCode {
	SUCCESS("000", "成功"),
	FAILED("400", "失败"),
	SYSTEM_ERROR("999", "系统异常，请联系管理员");
	private String code;

	private String message;

	private RespManageCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
