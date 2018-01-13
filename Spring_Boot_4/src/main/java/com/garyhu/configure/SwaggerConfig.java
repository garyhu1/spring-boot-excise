package com.garyhu.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("SeSpace")
				.genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("")// api测试请求地址
				.select().paths(PathSelectors.regex("/.*"))// 过滤的接口
				.build().apiInfo(testApiInfo());
	}

	private ApiInfo testApiInfo() {
		Contact contact = new Contact("garyhu", "http://www.superenginecloud.com", "huweiwei@superengine.com.cn");
		ApiInfo apiInfo = new ApiInfo("Spring Boot API", // 大标题
				"REST风格API", // 小标题
				"0.1", // 版本
				null, 
				contact, // 作者
				"超擎时空项目组", // 链接显示文字
				"http://www.superenginecloud.com"// 网站链接
		);
		return apiInfo;
	}
	
}
