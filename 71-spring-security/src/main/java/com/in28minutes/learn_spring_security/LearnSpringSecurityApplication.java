package com.in28minutes.learn_spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LearnSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringSecurityApplication.class, args);
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



//Spring Security - Learn Spring Security
//1.By Default, Everything is authenticated
//2.Form Based Authentication is Enabled
	//Form Based Authentication is used by most web applications
	//Uses a login form to collect username and password
	//Uses sessions and cookies to remember the logged in user
	//Eg: ajs_anonymous_id=ec8abce9-cc7d-4343-88b8-f4d4de8aa1c2; JSESSIONID=5A31DE5732C191CC8FE163631A61F4AA
	//This session id is sent as a cookie to identify the user for all subsequent requests
	//Provides default login & logout pages through /login & /logout endpoints

//3.Basic Authentication
	//Sends Base64 encoded username and password in the Authorization header
	//Not recommended for production , it has many flaws

//4.CSRF Protection
//CSRF Protection is by default enabled in Spring Security
//Spring Security allows READ Requests for Basic Authentication, However, Spring Security requires a CSRF token for WRITE Requests (POST, PUT, DELETE) which modifies the state of the server
//Synchronizer Token Pattern is used , A token is created for each request , To make an update(POST, PUT, DELETE), the client must send the token along with the request
//For Stateless Applications (REST APIs), we can disable CSRF protection in Spring Security Configuration

//5.CORS Configuration
//Browsers do not allow AJAX calls to resources residing outside the current origin
//CORS - Cross Origin Resource Sharing allow us to configure which cross domain requests are allowed

//6.Frames
//By default Spring Security disables Frames to avoid ClickJacking Attacks
//h2-console uses Frames to render the UI
//To enable h2-console, we need to enable Frames in Spring Security Configuration

//7.Storing User Credentials
//In-Memory Database - Not recommended for production
//JDBC - Recommended for production
//LDAP - Recommended for production
