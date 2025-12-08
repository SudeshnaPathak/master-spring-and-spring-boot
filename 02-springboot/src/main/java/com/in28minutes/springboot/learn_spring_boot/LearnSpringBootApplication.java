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
//Spring Boot Auto Configuration - Automatically configures DispatcherServlet , Embedded Servers (Tomcat, Jetty) , DataSource , JPA , Default Error Pages , Bean<->JSON Mapping , etc. based on the dependencies present in the classpath.
//Present in Spring Boot AutoConfigure jar

//Different logging levels in Spring Boot based on Hierarchy(For example all the levels below INFO will also be logged if the level is set to INFO):
//TRACE - Most detailed information. Expect these to be written in a log file only.
//DEBUG - Detailed information on the flow through the system.
//INFO - Interesting runtime events (startup/shutdown).
//WARNING - Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or unexpected, but not necessarily "wrong".
//ERROR - Runtime errors or unexpected conditions.
//OFF - Disable logging.