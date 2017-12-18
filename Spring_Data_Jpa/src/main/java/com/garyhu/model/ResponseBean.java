package com.garyhu.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseBean<T> {

	private int code;
	
	private List<T> result;
}
