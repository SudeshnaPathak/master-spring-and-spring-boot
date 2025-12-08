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

//Start Jar not War
//Default Embedded Server is Tomcat using spring-boot-starter-tomcat dependency

//Spring Boot Embedded Server(Tomcat) : (Simplify Deployment and Development)
//Step 0: mvn clean install (to build the jar file)
//Step 1: Run the jar file using the command: java -jar your-application.jar(Example : java -jar learn-spring-boot-0.0.1-SNAPSHOT.jar)
//Step 2: The embedded server (Tomcat) will start automatically.(Because Tomcat is already a part of jar file.)
//Step 3: Access the application at http://localhost:8080 (default port is 8080)

//Actuator endpoints : http://localhost:8080/actuator
//http://localhost:8080/actuator/bean - List all the Spring Beans & check autoconfiguration
//http://localhost:8080/actuator/health - Application Health Information
//http://localhost:8080/actuator/configprops - Configuration Properties
//http://localhost:8080/actuator/env - Environment Properties
//http://localhost:8080/actuator/metrics/<metric_name> - Application Metrics
//http://localhost:8080/actuator/mappings - All URL Mappings in the Application

//Spring Framework - Dependency Injection , @Component , @ComponentScan , @Autowired , etc.
//Spring MVC(Spring Module) - Simplify Web Apps and REST API , @RestController , @RequestMapping , @Controller etc.
//Spring Boot(Spring Project) - Build Production Ready Apps Quickly, Simplify Spring Application Development and Deployment , Auto Configuration , Starter Projects , Embedded Servers , Actuator , Error Handling , Profiles and Configuration , DevTools etc.