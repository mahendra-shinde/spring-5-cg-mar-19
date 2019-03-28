package com.mahendra;

public class IOCContainer {

	private CustomerDAO custDao;
	private CustomerManager manager;
	
	public IOCContainer() {
		custDao = new CustomerDAO();
		manager = new CustomerManager(custDao);
	}

	public CustomerDAO getCustDao() {
		return custDao;
	}

	public CustomerManager getManager() {
		return manager;
	}
	
	
}
