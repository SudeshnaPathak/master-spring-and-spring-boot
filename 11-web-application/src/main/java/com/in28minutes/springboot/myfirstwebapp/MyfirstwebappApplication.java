package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfirstwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstwebappApplication.class, args);
	}

}

//Browser sends a HTTP Request to the Server
//Server is our Spring Boot Application which handles the HTTP Request and sends back a HTTP Response