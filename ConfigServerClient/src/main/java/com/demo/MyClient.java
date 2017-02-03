package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class MyClient {

	public static void main(String[] args) {
		
		SpringApplication.run(MyClient.class, args);
		
	}
}

//@RefreshScope
@RestController
class MyController{
	
	@Value("${message:Hello default}")
	private String message;
	
	public String getMyMessage(){
		
		
		
		return "";
	}
	
}


