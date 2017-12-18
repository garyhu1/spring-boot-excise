package com.garyhu.advice;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

@ControllerAdvice
public class LogRequestBodyAdvice implements RequestBodyAdvice {

//	private Logger logger = LoggerFactory.getLogger(LogRequestBodyAdvice.class);
	
	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMesage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		Method method = parameter.getMethod();
        String classMappingUri = getClassMappingUri(method.getDeclaringClass());
        String methodMappingUri = getMethodMappingUri(method);
        if (!methodMappingUri.startsWith("/")) {
            methodMappingUri = "/" + methodMappingUri;
        }
//        logger.debug("uri={} | requestBody={}", classMappingUri + methodMappingUri, JsonDesUtils.toLogString(body));
		return body;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter arg1, Type arg2,
			Class<? extends HttpMessageConverter<?>> arg3) throws IOException {
		// TODO Auto-generated method stub
		return inputMessage;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage arg1, MethodParameter arg2, Type arg3,
			Class<? extends HttpMessageConverter<?>> arg4) {
		// TODO Auto-generated method stub
		return body;
	}

	@Override
	public boolean supports(MethodParameter arg0, Type arg1, Class<? extends HttpMessageConverter<?>> arg2) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private String getMethodMappingUri(Method method) {
        RequestMapping methodDeclaredAnnotation = method.getDeclaredAnnotation(RequestMapping.class);
        return methodDeclaredAnnotation == null ? "" : getMaxLength(methodDeclaredAnnotation.value());
    }

    private String getClassMappingUri(Class<?> declaringClass) {
        RequestMapping classDeclaredAnnotation = declaringClass.getDeclaredAnnotation(RequestMapping.class);
        return classDeclaredAnnotation == null ? "" : getMaxLength(classDeclaredAnnotation.value());
    }

    private String getMaxLength(String[] strings) {
        String methodMappingUri = "";
        for (String string : strings) {
            if (string.length() > methodMappingUri.length()) {
                methodMappingUri = string;
            }
        }
        return methodMappingUri;
    }

}
