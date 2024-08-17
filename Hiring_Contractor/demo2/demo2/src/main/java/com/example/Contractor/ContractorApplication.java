package com.example.Contractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class ContractorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractorApplication.class, args);
	}

}
