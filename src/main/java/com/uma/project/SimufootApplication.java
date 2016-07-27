package com.uma.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SimufootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimufootApplication.class, args);
	}
}
