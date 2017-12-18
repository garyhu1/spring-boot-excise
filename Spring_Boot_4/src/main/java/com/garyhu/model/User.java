package com.garyhu.model;

import org.hibernate.validator.constraints.NotBlank;

import com.garyhu.validate.Phone;

import lombok.Data;

@Data
public class User {

	@NotBlank(message = "用户名不能为空")
	@Phone
	private String username;
	private String password;
	
}
