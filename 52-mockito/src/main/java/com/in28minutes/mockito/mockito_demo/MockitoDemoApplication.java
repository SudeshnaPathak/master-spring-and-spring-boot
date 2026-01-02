package com.in28minutes.mockito.mockito_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockitoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoDemoApplication.class, args);
	}

}

//With spring-boot-starter-test dependency, Mockito is included by default.
//To Write Unit Tests for Classes with multiple dependencies, we use:
//Option 1: Stubs
//Option 2: Mock
