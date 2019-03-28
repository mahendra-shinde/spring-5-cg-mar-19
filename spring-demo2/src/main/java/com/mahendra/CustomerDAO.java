package com.mahendra;

import org.springframework.stereotype.Component;

//Dependency Object
@Component //Alternative to <bean> tag in XML 
public class CustomerDAO {
	
	public CustomerDAO() {
		System.out.println("Created an instance of DAO");
	}
	
	public void save(){
		System.out.println("Calling SAVE method!");
	}
}
