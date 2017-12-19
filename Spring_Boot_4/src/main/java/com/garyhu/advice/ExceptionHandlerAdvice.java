package com.garyhu.advice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garyhu.model.Result;
import com.garyhu.util.ResponseUtil;

import io.swagger.annotations.Api;

/**
 * 该页面用来处理可能出现的异常
 * @author garyhu
 *
 */
@ControllerAdvice
@ResponseBody
@Api(description="统一处理错误")
public class ExceptionHandlerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result handlerIllegalParamException(MethodArgumentNotValidException e){
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		String tips = "参数不合法";
		if(errors.size() > 0){
			tips = errors.get(0).getDefaultMessage();
		}
		return ResponseUtil.warn(tips, 3101);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public Result handlerResultException(RuntimeException e){
		return ResponseUtil.warn(e.getMessage(), 3081);
	}
	
	@ExceptionHandler(Exception.class)
	public Result handlerException(Exception e,HttpServletRequest request){
		return ResponseUtil.warn("网络异常，请检查网络状态", 2081);
	}
}
