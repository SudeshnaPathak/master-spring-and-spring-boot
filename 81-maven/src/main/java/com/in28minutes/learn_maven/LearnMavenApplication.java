package com.in28minutes.learn_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMavenApplication.class, args);
	}

}

//2 popular java Build Tools:
//Maven - Manages Project build , reporting & documentation
//Gradle
//Use of Maven:
//Create new Projects
//Manage dependencies(Frameworks & Libraries made use of in the project) - Downloads the dependencies & the transitive dependencies from POM.Xml, makes the jars available for the project
//Build a JAR File
//Run Applications on TomCat or jetty
//Run Unit Tests
//Deploy to a Test Environments

//From Parent pom : spring-boot-starter-parent
// We inherit spring boot dependencies , java version , plugin management , configurations
