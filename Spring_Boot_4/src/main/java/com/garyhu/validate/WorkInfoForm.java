package com.garyhu.validate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class WorkInfoForm {

	public interface Update{}
	
	public interface Add{}
	
	@NotNull(groups={Update.class})
	@Null(groups={Add.class})
	long id;
}
