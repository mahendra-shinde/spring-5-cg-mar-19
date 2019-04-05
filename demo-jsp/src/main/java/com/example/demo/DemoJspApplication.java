package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mahendra")
public class DemoJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJspApplication.class, args);
	}

}
