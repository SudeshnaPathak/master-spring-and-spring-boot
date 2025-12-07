package com.in28minutes.learn_spring_framework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Java Record to hold Person data
record Person(String name, int age , Address address){ }
// Java Record to hold Address data
record Address(String firstLine, String city){ }

@Configuration
public class HelloWorldConfiguration {
    // Configure the Spring Beans
    //@Bean - auto wiring is performed using method calls or method parameters
    @Bean
    public String name() {
        return "Sudeshna";
    }

    @Bean
    public int age() {
        return 21;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 25 , new Address("Main Street" , "Utrecht"));
    }

    @Bean(name = "address2") // Custom Bean Name
    @Primary
    public Address address(){
        return new Address("Baker's Street", "London");
    }

    @Bean
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("Motinagar", "Hyderabad");
    }

    @Bean
    public Person person2MethodCall(){
        //Auto wiring using Method Calls
        return new Person(name() , age() , address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        // Creating Bean using existing Beans as Parameters
        // Auto wiring using Parameters
        return new Person(name , age , address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address){
        return new Person(name , age , address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address){
        return new Person(name , age , address);
    }
}
