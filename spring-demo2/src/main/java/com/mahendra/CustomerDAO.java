package com.mahendra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Dependency Object
@Component("dao")  //Alternative to <bean> tag in XML
@Scope("prototype")
public class CustomerDAO {
	
	public CustomerDAO() {
		System.out.println("Created an instance of DAO");
	}
	
	public void save(){
		System.out.println("Calling SAVE method!");
	}
	
	@PostConstruct
	public void doInit()
	{
		System.out.println("Initializing the DAO");
	}
	
	@PreDestroy
	public void doDestroy() {
		System.out.println("About to destroy the DAO!");
	}
}
