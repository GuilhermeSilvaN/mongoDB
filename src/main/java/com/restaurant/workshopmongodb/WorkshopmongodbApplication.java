package com.restaurant.workshopmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WorkshopmongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongodbApplication.class, args);
	}

}
