package com.garyhu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garyhu.config.Message;
import com.garyhu.config.Student;
import com.garyhu.entity.User;
import com.garyhu.model.ResponseBean;
import com.garyhu.model.SearchBean;
import com.garyhu.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	Student student;
	
	@Resource
	UserRepository userRepository;

	@PostMapping("/getUser")
	@ResponseBody
	public Object user(@RequestParam(value="id",required=false) int name){
		return userRepository.queryUser(name);
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/student")
	@ResponseBody
	public Message getStudent(){
		Message msg = new Message();
		msg.setAge(student.getAge());
		msg.setId(student.getId());
		msg.setMessage(student.getMessage());
		msg.setName(student.getName());
		return msg;
	}
	
	@GetMapping("/saveUser/{name}/{id}")
	public String saveUser(@PathVariable(value="name") String name,@PathVariable(value="id") Integer id){
		System.out.println(name+"::"+id);
		userRepository.saveUser(name,id);
		return "index";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam(value="name") String name,@RequestParam(value="departmentId") Integer departmentId){
		User u = new User();
		u.setName(name);
		u.setDepartmentId(departmentId);
		userRepository.save(u);
		return "redirect:/";
	}
	
	@PostMapping("/search")
	@ResponseBody
	public Object search(@RequestBody SearchBean bean){
		Pageable page = new PageRequest(bean.getPage(),bean.getSize());
		Page< User> pageObject = userRepository.getUser(bean.getDepartmentId(), page);
		long count= pageObject.getTotalElements() ;
		ResponseBean<User> res = new ResponseBean();
		res.setCode(200);
		res.setResult(pageObject.getContent());
		return res;
	}
	
}
