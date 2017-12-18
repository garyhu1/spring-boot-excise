package com.garyhu.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="student")
@Data
public class Student implements Serializable{

	private static final long serialVersionUID = -3155826961782413422L;
	
	private String message;
	private int id;
	private int age;
	private String name;
}
