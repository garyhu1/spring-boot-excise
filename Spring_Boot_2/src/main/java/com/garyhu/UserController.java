package com.garyhu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	@ResponseBody
	public User getUser(){
		User user = new User();
		user.setId(110123);
		user.setName("Jackson");
		user.setGender("male");
		
		List<Student> students = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setClazzName("三年一班");
		s1.setCode(11012301);
		s1.setName("小明");
		Student s2 = new Student();
		s2.setClazzName("三年二班");
		s2.setCode(11012302);
		s2.setName("小猪");
		Student s3 = new Student();
		s3.setClazzName("三年三班");
		s3.setCode(11012303);
		s3.setName("小红");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		user.setStudents(students);
		return user;
	}
	
	@RequestMapping("/user")
	public String user(){
		return "user";
	}
}
