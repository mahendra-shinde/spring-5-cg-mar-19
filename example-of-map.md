## Example of Map

	//Property of Type MAP
	private Map<String,Double> exchangeRates;
	
	public ExchangeServiceImpl(Map<String,Double> exRates) {
		System.out.println("ExchangeServiceImpl()");
		this.exchangeRates = exRates;
	}
	public double getExchangeRate(String currency) {
		System.out.println("getExchangeRate()");
		return exchangeRates.get(currency);
	}

### XML Mapping

	<bean id="exchangeService" class="com.igate.intro.ExchangeServiceImpl">
	  <constructor-arg>
	  	<map>
	  		<entry key="INR" value="67.1"/>
	  		<entry key="SGD" value="1.02"/>
	  		<entry key="JPY" value="79.8"/>
	  	</map>
	</constructor-arg>
	</bean>