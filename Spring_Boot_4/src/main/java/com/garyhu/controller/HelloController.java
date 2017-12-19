package com.garyhu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController//相当于@Controller和@ResponseBody
@Api(description="欢迎")
public class HelloController {
	
	@ModelAttribute
	public void set(Model model){
		model.addAttribute("user","darlin");
	}

	@GetMapping("/sayHello.html")
	public String say(@RequestParam(value="name",required=false) String name,Model model){
		boolean flag = model.containsAttribute("user");
		System.out.println(flag);
		return "Hello "+ name;
	}
}
