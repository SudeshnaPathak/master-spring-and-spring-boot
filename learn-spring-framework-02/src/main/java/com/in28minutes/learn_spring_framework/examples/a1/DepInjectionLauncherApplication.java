package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
@ComponentScan // Automatically scans the current package and its sub-packages for @Component classes
public class DepInjectionLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class))
        {
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
