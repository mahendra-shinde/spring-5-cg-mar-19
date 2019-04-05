package com.mahendra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("manager") //Alternative <bean> tag
public class CustomerManager {
private CustomerDAO dao;
	
	//Example of Constructor Injection
	// Target class (CustomerManager) gets dependency (CustomerDAO)
	// Via its constructor!!	
	@Autowired  //Perform Dependency Injection
	public CustomerManager(CustomerDAO dao) {
	this.dao = dao;
	
	System.out.println("Created instanced of business tier");
	}
	
	//Example of Setter Injection
	// Target class (CustomerManager) gets dependency (CustomerDAO)
	// Via its Setter method!!	
	public void setCustomerDAO(CustomerDAO dao) {
		this.dao = dao;
	}
	
	public void save(){
		dao.save();
}
}
