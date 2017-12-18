package com.garyhu.validate;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");
	private Phone phone;
	
	//用来初始化一些参数
	@Override
	public void initialize(Phone p) {
		this.phone = p;
	}

	//进行验证
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value!=null&&pattern.matcher(value).matches();
	}

}
