package com.garyhu.advice;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class LogResponseBodyAdvice implements ResponseBodyAdvice {
	
//	private Logger logger = LoggerFactory.getLogger(LogResponseBodyAdvice.class);

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter arg1, MediaType arg2, Class arg3, ServerHttpRequest request,
			ServerHttpResponse response) {
//		logger.debug("uri={} | responseBody={}", request.getURI().getPath(), JsonDesUtils.toLogString(body));
		return body;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
