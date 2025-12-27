package com.in28minutes.rest.webservices.restful_web_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	//http://localhost:3000/ to 8080
    //Cross Origin Requests are blocked by default by browsers.
    //Allow all Requests from http://localhost:3000/
	//Define a Bean to configure CORS settings
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
			// Override the addCorsMappings method of WebMvcConfigurer to allow CORS requests
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") //Add mapping to allow CORS requests to all endpoints
						.allowedMethods("*") //Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
						.allowedOrigins("http://localhost:3000"); //Allow requests from this origin
			}
        };
    }
}

