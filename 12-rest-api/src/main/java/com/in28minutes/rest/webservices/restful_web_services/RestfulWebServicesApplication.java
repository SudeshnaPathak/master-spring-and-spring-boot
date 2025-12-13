package com.in28minutes.rest.webservices.restful_web_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}

//Magic happens cos of Starter Projects and Auto Configuration

//Requests first go to a DispatcherServlet(Front Controller) url=[/]
//DispatcherServlet maps the request to a specific Controller
//DispatcherServlet is autoconfigured

//Error Handling
//Auto Configured : ErrorMvcAutoConfiguration ~ To Configure an Error Page

//Tomcat is the default embedded server, it is also autoconfigured