package com.cg.webapp.utils;


// User defined exception for Invalid or Non existing Country Codes.
public class NoCountryFoundException extends RuntimeException {

	public NoCountryFoundException(String countryCode) {
		super("Country with code "+countryCode+" does not exists!");
		// TODO Auto-generated constructor stub
	}

	
}
