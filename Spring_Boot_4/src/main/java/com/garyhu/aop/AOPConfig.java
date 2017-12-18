package com.garyhu.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AOPConfig {

	@Around("execution(* com.garyhu.controller.*.*(..))")
	public Object simpleAop(ProceedingJoinPoint pjp)throws Throwable{
		try{
			Object[] args = pjp.getArgs();
			System.out.println ( " args :"+Arrays.asList(args)) ;
			//调用原来的方法
			Object o = pjp.proceed();
			System.out.println("return : "+o);
			return o;
		}catch(Throwable a) {
			throw a;
		}
	}
}
