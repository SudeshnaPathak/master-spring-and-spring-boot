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