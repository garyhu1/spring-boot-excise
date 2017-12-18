package com.garyhu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.garyhu.model.FileBean;
import com.garyhu.model.Result;
import com.garyhu.model.User;
import com.garyhu.util.ResponseUtil;
import com.garyhu.validate.Phone;

@Controller
public class IndexController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	@GetMapping("/")
	public String index(Date d){
		System.out.println(d);
		return "wp/main";
	}
	
	@PostMapping("/upload")
	public @ResponseBody Result upload(@RequestParam(name="file") MultipartFile file){
		FileBean bean = new FileBean();
		try {
			if(!file.isEmpty()){
				String originalName = file.getOriginalFilename();//获取文件名称
				InputStream inputStream = file.getInputStream();//获取字节流
				byte[] bytes = file.getBytes();//获取上传内容并转化为字节数组
				String contentType = file.getContentType();//内容类型
				long size = file.getSize();//获取上传文件大小
				String name = file.getName();
//				bean.setBytes(bytes);
				bean.setContentType(contentType);
				bean.setName(name);
				bean.setOriginalFileName(originalName);
				bean.setSize(size);
//				bean.setInputStream(inputStream);
				inputStream.close();
			}
		}catch(IOException e){
			e.printStackTrace();
			return ResponseUtil.warn("异常了",300);
		}
		return ResponseUtil.success(bean);
	}
	
	@PostMapping("/admin/login")
	@ResponseBody
	public Object login(@RequestBody @Validated User user,Model model){
		//可以通过user来查询数据库来获取数据，再转换为json返回
		model.addAttribute("message","success");
		System.out.println("login : "+user.getUsername());
		return ResponseUtil.success(user);
	}

}
