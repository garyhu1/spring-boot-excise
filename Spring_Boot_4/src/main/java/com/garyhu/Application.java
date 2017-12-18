package com.garyhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * 如果你的Web 服务器是Weblogic ，还需要一些额外的方法，首先程序入口需要完成WebApplicationinitializer 接口
 * @author garyhu
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer{

	public static void main(String[] args)throws Exception{
		SpringApplication.run(Application.class,args);
	}
	
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Application.class);
	}
}
