package com.in28minutes.learn_spring_framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}

@Component
@Lazy //ClassB is not initialized at the startup of the context , it is initialized only when it is requested
class ClassB{
    private final ClassA classA;

    public ClassB(ClassA classA) {
        //logic
        System.out.println("Some Initialization Logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Doing something");
    }

}

@Configuration
@ComponentScan
public class LazyInitializationContextLauncher {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(LazyInitializationContextLauncher.class))
        {
           System.out.println("Context is initialized");
           context.getBean(ClassB.class).doSomething();
           //Eager Initialization - All the beans are initialized when the context is initialized, i.e at the startup of the application
           //Lazy Initialization - Beans are initialized only when they are requested(Rarely used or not recommended)
            // Default initialization of Bean is Eager
            //Eager Initialization is recommended because it helps to identify configuration issues immediately at startup rather than at runtime
            //Memory Consumption is less in case of Lazy Initialization as compared to Eager Initialization
        }
    }
}
