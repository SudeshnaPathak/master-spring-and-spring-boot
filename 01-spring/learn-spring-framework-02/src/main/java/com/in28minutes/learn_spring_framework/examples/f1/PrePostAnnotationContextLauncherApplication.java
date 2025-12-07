package com.in28minutes.learn_spring_framework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private final SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready to use!");
    }

    @PostConstruct //This method will be executed as soon as the bean is created and all the dependencies are injected
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy //This method will be executed just before the bean is destroyed/Removed from Container, to release resources
    public void cleanUp(){
        System.out.println("Clean up logic before bean is destroyed");
    }
}

@Component
class SomeDependency{
    public void getReady() {
        System.out.println("Some Logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class))
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
