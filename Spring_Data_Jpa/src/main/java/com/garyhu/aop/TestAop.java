package com.garyhu.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class TestAop {

	@Around("within(@org.springframework.stereotype.Controller*)&&@ann")
	public void getDemo(){
		
	}
}
