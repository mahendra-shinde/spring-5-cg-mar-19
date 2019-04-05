package com.mahendra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration	//Define this CLASS as Configuration 
				//Its REPLACING an XML file
public class AppConfig {
	
	@Bean	//REPLACEMENT for <bean> in XML
	@Scope("prototype")
	public CustomerDAO dao() {
		return new CustomerDAO();
	}
	
	@Bean
	public CustomerManager manager() {
		//Example of AUTOWIRING in BEAN
		return new CustomerManager(dao());
	}

}
