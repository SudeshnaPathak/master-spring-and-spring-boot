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

//GroupId : Similar to package name , uniquely identifies your project across all projects
//ArtifactId : Similar to class name , uniquely identifies your project within the group
//Version : version of the project

//Once we push our dependencies to a Maven Repository , other projects can make use of these dependencies by using our GroupId , ArtifactId & Version

//Maven Central Repository : Contains all the jars indexed by GroupId , ArtifactId & Version
//When a dependency is added in the POM.xml file , Maven checks in the Central Repository for the jar
//These Jars are downloaded from Maven Central Repository to our Maven Local Repository
//In our project , we are making use of the jars from the Maven Local Repository
//Maven Local Repository : A temp folder on our machine where maven stores all the jars & dependency files downloaded from the Central Repository

//mnv commands:
// mvn --version : to check maven version
// mvn compile : to compile source files
// mvn test-compile : to compile test files(also compiles source files if not already compiled)
// mvn clean : to clean the target folder
// mvn test : to run tests(also compiles source & test files if not already compiled)
// mvn package : to create a jar file(also runs tests, compiles source & test files if not already done)
// mvn dependency:tree : to view dependency tree of the project
// mvn help:effective-pom : to view the effective pom including inherited dependencies & plugins from parent pom