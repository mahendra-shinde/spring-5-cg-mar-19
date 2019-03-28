package com.mahendra;

public class Main {

	public static void main(String[] args) {
		//Initialize the IoC Container
		IOCContainer container = new IOCContainer();
		
		//Get all required objects from IoC Container!
		CustomerDAO dao = container.getCustDao();
		
		CustomerManager man1 = container.getManager();
		CustomerManager man2 = container.getManager();
		
	}

}
