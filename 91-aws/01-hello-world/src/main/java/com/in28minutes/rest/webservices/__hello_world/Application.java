package com.in28minutes.rest.webservices.__hello_world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//Deployment to Elastic Beanstalk:
//Create a JAR file using Maven or Gradle.
//Go to Elastic Beanstalk in the AWS Management Console.
//Create a new application
//Create a new environment (Web server environment).
//Configure application name, platform (Java), use a corretto version which >= your JDK version.
//Upload the JAR file.
//Add a version label after uploading the JAR file to track deployments.
//Launch the application.
//Access the application using the provided URL from Elastic Beanstalk.