# Bean Wiring and Auto-Wiring
### Classes 

	class Car { 

		private Engine eng1;
	
		public Car(Engine eng1){
			this.eng1 = eng1;
		}
	}

	class Engine {
	

	}

### Example of Manual Bean Wiring 
	<bean id="eng1" class="package.Engine"/>

		<bean id="car1" class="package.Car">
		<constructor-arg ref="eng1"/>
	</bean>

### Example of Auto Wiring ( By Constructor ) 

	<bean id="eng1" class="package.Engine"/>

	<bean id="car1" class="package.Car" autowire="constructor">
		<!-- Let Spring search for Constructor Arguments
		and auto-wire them with Beans of matching Type! 
		WARNING : Fails if multiple matching beans found for same argument
	 -->
	</bean>

### Example of Auto Wiring ( By Name ) 

	<bean id="eng1" class="package.Engine"/>
	<bean id="eng2" class="package.Engine"/>

	<bean id="car1" class="package.Car" autowire="byName">
	<!-- Let Spring search for
	Constructor Arguments and auto-wire them with Beans of matching ID 
	NOTE: Can be used with both	Constructor & Setter method
	WARNING : Fails if bean ID doesn't match with setter method
	argument or constructor argument
	 -->
	</bean>

### Example of Auto Wiring ( By Type )
	<bean id="eng1" class="package.Engine"/>
	<bean id="eng2" class="package.Engine"/>

	<bean id="car1" class="package.Car" autowire="byType">
	<!-- Let Spring search for Setter Arguments
	and auto-wire them with Beans of matching Type! 
	NOTE: Only if "setEngine" method exists in class Car
	WARNING : Fails if multiple matching beans found for same argument
	 -->
	</bean>