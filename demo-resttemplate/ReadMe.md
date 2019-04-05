## Spring Boot RestTemplate demo
This sample application demonstrate using **RestTemplate** to consume RestFul services.

### Steps
1.	In STS, Create new **Spring Starter Project**
	
		projectname: demo-resttemplate
		packaging:		JAR
		groupid:			com.mahendra
		dependency:		Web
		
		Click "Finish"

2.	Create new Model class **Country**

		public class Country {
		
			private String code;
			
			private String name;
			
			private Integer region;
		
			public Country() {
				super();
				// TODO Auto-generated constructor stub
			}
			//TODO: Add getters and setters		
		}

3.	Open **DemoResttemplateApplication** (which contains MAIN method).
	
	
	3.1	Implement __CommandLineRunner__ interface.
	
	3.2	Add following method:

			public void run(String... args) throws Exception {
				RestTemplate template = new RestTemplate();
			Country country = 
					template.getForObject
						("http://localhost:5000/countries/find/IN",
								Country.class);
			
			System.out.println("Country details: "+country.getName());
			
			}

4.	Open & Run **rest-jpa-demo** on port 5000.
5.	Run the current demo as "Java Application" or "Spring Boot Application".
		