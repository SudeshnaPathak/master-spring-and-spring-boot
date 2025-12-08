package com.in28minutes.springboot.learn_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}

//Springboot Starter Projects - A collection of all the dependencies you need to build a specific type of application. For example, spring-boot-starter-web for web applications, spring-boot-starter-data-jpa for JPA-based data access, etc.
//Spring Boot Auto Configuration - Automatically configures DispatcherServelet , Embedded Servers (Tomcat, Jetty) , DataSource , JPA , Default Error Pages , Bean<->JSON Mapping , etc. based on the dependencies present in the classpath.
//Present in Spring Boot AutoConfigure jar