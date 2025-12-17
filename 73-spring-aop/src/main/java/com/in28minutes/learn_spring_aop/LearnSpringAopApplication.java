package com.in28minutes.learn_spring_aop;

import com.in28minutes.learn_spring_aop.aopexample.business.BusinessService1;
import com.in28minutes.learn_spring_aop.aopexample.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {

	//CommandLineRunner -> run method immediately after application context is loaded

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final BusinessService1 businessService1;
	private final BusinessService2 businessService2;

	public LearnSpringAopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
        this.businessService2 = businessService2;
    }

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value returned by BusinessService1 : {} ", businessService1.calculateMax());
		logger.info("Value returned by BusinessService2 : {} ", businessService2.calculateMin());
	}
}


//Layered Approach
//Web Layer - View Logic/Serialization
//Business Layer - Business Logic
//Data Layer - Persistence Logic

//Few Common Aspects which apply to all layers ~ Cross Cutting Concerns
//Security
//Logging

//Aspect Oriented Programming(AOP) implements Cross Cutting Concerns
//1.Define Aspects ~Like Security , logging etc
//2.Define point cuts where aspects will be applied ~Web Layer , Business Layer

//FrameWorks(Weavers) to implement AOP in Spring:
//1.Spring AOP ~ (not a complete AOP , popular solution)
//2.ASpectJ ~ (complete AOP , rarely used , more flexible)