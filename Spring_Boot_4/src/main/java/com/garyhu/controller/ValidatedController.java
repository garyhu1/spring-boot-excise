package com.garyhu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garyhu.validate.WorkInfoForm;

@Controller
public class ValidatedController {

	@PostMapping("/validate")
	@ResponseBody
	public String validate(@Validated({WorkInfoForm.Update.class}) @RequestBody WorkInfoForm info,BindingResult result){
		if(result.hasErrors()){
			List<ObjectError> errs = result.getAllErrors();
			FieldError err = (FieldError)errs.get(0);
			String errorArgs = err.getObjectName()+" , "+err.getField()+" , "+err.getDefaultMessage();
			return errorArgs;
		}
		return "success";
	}
}
