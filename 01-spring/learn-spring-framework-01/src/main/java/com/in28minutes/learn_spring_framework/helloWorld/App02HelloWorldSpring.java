package com.in28minutes.learn_spring_framework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args)
    {
        // JVM -> Spring Context (IOC Container) -> Spring Bean
        // IOC - Inversion of Control : Bean Factory or Application Context to manage the Beans and their lifecycle
        //1. Launch a Spring Context
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class))
        {
            //2. Configure the things that we want Spring to manage(Spring Beans)
            // HelloWorldConfiguration class - @Configuration
            // name method - @Bean

            //3. Retrieving Beans managed by Spring Context
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));

            System.out.println(context.getBean(Address.class)); // Get Bean by Type
            System.out.println(context.getBean(Person.class));

            System.out.println(context.getBean("person5Qualifier"));
            // List all Bean Definitions
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // Print all Bean Names using Functional Programming

        }
    }
}
