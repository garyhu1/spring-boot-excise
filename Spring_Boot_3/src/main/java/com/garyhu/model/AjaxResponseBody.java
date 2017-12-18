package com.garyhu.model;

import java.util.List;

import com.garyhu.pojo.User;

import lombok.Data;

@Data
public class AjaxResponseBody {

	private String msg;
	private List<User> result;
}
