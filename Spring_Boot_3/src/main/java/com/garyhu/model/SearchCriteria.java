package com.garyhu.model;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class SearchCriteria {

	@NotBlank(message = "username can't empty!")
    String username;
}
