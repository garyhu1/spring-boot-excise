package com.garyhu.model;

import java.io.InputStream;

import lombok.Data;

@Data
public class FileBean {

	private String originalFileName;
	private byte[] bytes;
	private InputStream inputStream;
	private long size;
	private String contentType;
	private String name;
	
}
