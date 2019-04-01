package com.mahendra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		//Initializing Context (Spring IOC Container) 
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("spring.xml");
		
		//Get Dao Object by TYPE 
		//(Incase more than ONE object of given type found,
		//	then Throw an exception)
		CustomerDAO dao1 = context.getBean(CustomerDAO.class);
		
		//Get Dao object by ID
		CustomerDAO dao2 = (CustomerDAO)context.getBean("dao");
		
		CustomerManager man = context.getBean(CustomerManager.class);
		System.out.println("dao1 and dao2 are same objects? "+(dao1==dao2));
		
		context.close();
	}

}
