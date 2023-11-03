package com.java;

import javax.validation.constraints.Pattern;

public class Student {
	@Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", 
			 message = "student name must be of 6 to 12 length with no special characters") 
			private String name;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!#%*?&]{6,20}$", 
			 message = "password must contain at least 1 lowercase, 1uppercase , 1 special character(!@#$&*) and 1 digit ") 

	private String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
