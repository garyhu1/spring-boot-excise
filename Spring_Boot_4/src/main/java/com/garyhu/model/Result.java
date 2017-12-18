package com.garyhu.model;

import lombok.Data;

@Data
public class Result<T> {

	private int code;
	private String msg;
	private T result;
}
