package com.sisrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SisrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisrestApplication.class, args); 
	}

}
