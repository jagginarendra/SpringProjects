package com.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
public class TestClient {

	public static void main(String[] args) {
		
		SpringApplication.run(TestClient.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate RestTemplate(){
		
		return new RestTemplate();
	}
}
