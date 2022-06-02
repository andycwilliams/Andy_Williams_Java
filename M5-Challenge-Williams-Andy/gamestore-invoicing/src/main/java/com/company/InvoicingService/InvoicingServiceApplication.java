package com.company.InvoicingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InvoicingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoicingServiceApplication.class, args);
	}

}
