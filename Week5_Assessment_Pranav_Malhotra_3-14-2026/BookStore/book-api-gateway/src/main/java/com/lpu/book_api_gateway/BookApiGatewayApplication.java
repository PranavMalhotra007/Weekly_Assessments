package com.lpu.book_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class BookApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiGatewayApplication.class, args);
	}

}
