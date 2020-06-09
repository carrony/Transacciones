package com.dred.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransaccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransaccionesApplication.class, args);
	}

}
