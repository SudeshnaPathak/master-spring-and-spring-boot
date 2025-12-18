package com.in28minutes.learn_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnGradleApplication.class, args);
	}

}

//Gradle

//1.Build Anything : Cross Platform Tool(Can be used to build C/C++ , Java , JavaScript , Python) , Unlike Maven(Platform Dependant) which is only used for Java Builds

//2.Automate Everything :
//-> Completely Programmable(No XML Configs)
//-> Supports DSL ~ Groovy & Kotlin

//3.Faster Builds
//-> Incrementality (Runs only changed Files)
//-> Build Cache(Reuses the build outputs of other builds with same inputs)

//4.Same Project Layout as Maven

//5.IDE Support for Gradle is still evolving

//Build.gradle ~ all dependencies and plugins are defined here , groupId , version etc. It is similar to pom.xml in Maven
//settings.gradle ~ project related settings are defined here , like artifactId , project name etc.
//Build.gradle also makes use of Maven Central Repository to fetch dependencies

//java plugin ~ Java compilation , testing , building jar files , Defines standard directory structure (src/main/java , src/test/java etc.)
//Key Task: Build

//Dependancy Management plugin ~ For Maven style dependency management
//Eg: group: 'org.springframework.boot' , name: 'spring-boot-starter-webmvc' , version: '2.7.5'
//short form : implementation 'org.springframework.boot:spring-boot-starter-webmvc:2.7.5'

//Spring Boot plugin ~ Spring Boot support for Gradle
//Build Spring Boot executable jar files
//Build Spring Boot Docker images
//Automatic dependency management for Spring Boot projects , no need to define versions for Spring Boot dependencies