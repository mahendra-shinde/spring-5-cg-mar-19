package com.cg.ctlr;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	@NotEmpty(message="Firstname is required")
	@Size(max=50, min=5, message="First name must contain 5 to 50 characters")
	private String firstName;

	@Size(max=50, min=5, message="Last name must contain 5 to 50 characters")
	@NotEmpty(message="Lastname is required")
	private String lastName;
	
	private char gender ;
	
	@Email(message="Invalid email address")
	@NotEmpty(message="EMail required")
	private String email;
	
	//No Validation
	private String[] skillSet;
	//No Validation
	private String city;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String[] skillSet) {
		this.skillSet = skillSet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
