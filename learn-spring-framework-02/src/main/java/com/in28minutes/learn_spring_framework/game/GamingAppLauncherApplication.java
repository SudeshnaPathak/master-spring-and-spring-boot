package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game") // To scan for @Component classes in the specified package and their sub-packages
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class))
       {
           // Auto-wiring by Spring Framework - it will search for beans of type GamingConsole and type GameRunner using @ComponentScan and inject it here
           // When we launch the GamingAppLauncherApplication -> Spring performs Component Scan in the right package -> finds the classes with @Component -> creates the Beans for these classes -> Retrieve the beans -> Gets the application up and running
           context.getBean(GamingConsole.class).up();
           context.getBean(GameRunner.class).run();

           //Inversion of Control (IoC) - The control of creating & managing the objects is inverted from the Programmer to the Spring Framework
           //Spring Bean - An object that is created, managed and injected by the Spring Framework is called a Spring Bean
           //IOC Container - Manages the lifecycle of Spring Beans & their dependencies - Creation, Configuration, Management, Destruction
           // 2 Types of IOC Containers - BeanFactory (Basic - rarely used), ApplicationContext (Advanced with more features)
       }
    }
}
