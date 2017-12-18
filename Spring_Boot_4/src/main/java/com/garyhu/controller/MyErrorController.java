package com.garyhu.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garyhu.model.Result;
import com.garyhu.util.ResponseUtil;
/**
 * 统一处理页面错误
 * @author garyhu
 *
 */
//@Controller
//@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}
    
	//返回一个json来提示
//	@RequestMapping
//	@ResponseBody
	public Result doHandlerError(){
		return ResponseUtil.warn("页面存在错误", 500);
	}
	
	//返回一个页面来显示错误
//	@RequestMapping
	public String errorPage(){
		return "error/error";
	}
}
