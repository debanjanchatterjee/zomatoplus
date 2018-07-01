package com.thinkxfactor.zomatoplus.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // starting point 
@ComponentScan("com.thinkxfactor") // search for all the beans in the packages
@EnableJpaRepositories(basePackages = "com.thinkxfactor") // enables the jpa repo for the base package
@EntityScan("com.thinkxfactor")  // looks for all the objects that have @Entity above it

public class ZomatoplusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZomatoplusApplication.class);
	}
	
	
}
