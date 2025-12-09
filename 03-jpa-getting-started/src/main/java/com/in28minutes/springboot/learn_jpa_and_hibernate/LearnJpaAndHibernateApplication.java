package com.in28minutes.springboot.learn_jpa_and_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
	}

}

//url to access h2-database console
//http://localhost:8080/h2-console

//JDBC : Write SQL Queries , map ResultSet to Objects
//JPA : Jakarta Persistence API
//JPA : Don't worry about SQL Queries , map Entities to Database tables
//Spring Data JPA :
//Here we don't need to talk to EntityManager or write any SQL queries. Spring Data JPA will take care of all these low-level details.
// We just need to define an interface that extends JpaRepository and Spring Data JPA will provide the implementation automatically at runtime.
// This is one of the powerful features of Spring Data JPA that simplifies data access in Spring applications.

//JPA vs Hibernate
//JPA defines the specifications. It is an API. How to map Entities , Attributes , Manage Entity Lifecycle etc.
//Hibernate is the most popular implementation of JPA specifications.
//Using JPA allows you to switch between different JPA implementations (like Hibernate, EclipseLink, TopLink etc.) without changing your code.
//We don't want to lock in to Hibernate only. So we use JPA abstractions over Hibernate.
