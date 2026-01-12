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
						.allowedOrigins("*"); //#CHANGE : Allow all origins. In production, specify s3 bucket URL instead of *
			}
        };
    }
}

//JWT : Json Web Token
//Industrial Standard for securely transmitting information between parties as a JSON object.
//Can contain user details and claims
//Header: Type : JWT, Algorithm: HS256
//Payload:
//Standard Claims:
//  iss: issuer
//  sub: subject
//  iat: issued at
//  exp: expiration
//Custom Claims:
//  roles: user roles
//  permissions: user permissions
//Signature: Includes a secret key known only to the server to verify the token's integrity and authenticity.

//JWT Flow:
//Request with username and password
//Response with JWT token

//All JWT classes must be created in the jwt package for components scan to work properly
