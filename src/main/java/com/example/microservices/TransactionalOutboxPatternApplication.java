package com.example.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalOutboxPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalOutboxPatternApplication.class, args);
	}

}
