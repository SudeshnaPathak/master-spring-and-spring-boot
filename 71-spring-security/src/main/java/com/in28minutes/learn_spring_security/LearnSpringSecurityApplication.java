package com.in28minutes.learn_spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringSecurityApplication.class, args);
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
