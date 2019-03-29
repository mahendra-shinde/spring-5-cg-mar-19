package com.igate.intro;

import java.util.Map;

public class ExchangeServiceImpl implements ExchangeService {

	private Map<String,Double> exchangeRates;
	
	public ExchangeServiceImpl(Map<String,Double> exRates) {
		System.out.println("ExchangeServiceImpl()");
		this.exchangeRates = exRates;
	}
	public double getExchangeRate(String currency) {
		System.out.println("getExchangeRate()");
		return exchangeRates.get(currency);
	}
}
