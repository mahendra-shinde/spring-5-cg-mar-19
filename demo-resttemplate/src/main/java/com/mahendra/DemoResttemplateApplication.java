package com.mahendra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.mahendra.models.Country;

@SpringBootApplication
public class DemoResttemplateApplication implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoResttemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate();
	Country country = 
			template.getForObject
				("http://localhost:5000/countries/find/IN",
						Country.class);
	
	System.out.println("Country details: "+country.getName());
	
	}

}
