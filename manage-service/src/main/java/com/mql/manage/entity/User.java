package com.mql.manage.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Data //get set
@Accessors(chain = true)
//@AllArgsConstructor
@Table(name="t_user")
public class User {
	@Id
	private Integer id;
	
	private String loginName;
	
	private String loginPwd;
	
	private String userName;
	
	private String mobile;
	
	private String email;
	
	private String status;
	
	private Date createTime;
	
	
}
