package com.mahendra;

//Example of IOC Container
// Creates a POOL of Object with all dependencies INJECTED in targets
// Client (MAIN method) can acquire any object easily from POOL
public class IOCContainer {

	private CustomerDAO custDao;
	private CustomerManager manager;
	
	public IOCContainer() {
		custDao = new CustomerDAO();
		//Example of Constructor Injection
		manager = new CustomerManager(custDao);
		//Example of Setter Injection
		manager.setCustomerDAO(custDao);
	}

	public CustomerDAO getCustDao() {
		return custDao;
	}

	public CustomerManager getManager() {
		return manager;
	}
	
	
}
