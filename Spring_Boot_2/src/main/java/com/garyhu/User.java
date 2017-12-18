package com.garyhu;

import java.util.List;

import lombok.Data;

@Data
public class User {

	private int id;
	private String name;
	private String gender;
	private List<Student> students;
}
