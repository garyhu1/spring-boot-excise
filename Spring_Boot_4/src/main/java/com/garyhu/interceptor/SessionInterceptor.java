package com.garyhu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor  {

	//页面渲染完成后调用 ，通常用来清除某些资源，类似Java 语法的finally
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
		
	}

	// Controller 方法处理完毕后，调用此方法
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView mav)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		
	}

	//在Controller方法之前调用
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
