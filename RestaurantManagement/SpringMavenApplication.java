   package com.example.RestaurantManagement;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//main method available
	/* @SpringBootApplication: A convenience annotation that combines @Configuration, 
	 * @EnableAutoConfiguration, and @ComponentScan. It enables auto-configuration and 
	 * component scanning within the package and its sub-packages.*/
 
public class SpringMavenApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMavenApplication.class, args);
	}

}
 