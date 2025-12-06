package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourFieldInjection{
    //Field Injection : No Setter or Constructor needed, Dependency is injected using Reflection
    @Autowired // When we place autowired over a field, Spring searches for a bean of type Dependency1 and injects it here
   Dependency1 dependency1;
    @Autowired
   Dependency2 dependency2;

   public String toString(){
       return "Using "+ dependency1 + " and " + dependency2;
   }
}

@Component
class YourSetterInjection{
    Dependency1 dependency1;
    Dependency2 dependency2;

    @Autowired // When we place autowired over a setter method, Spring searches for a bean of type Dependency1 and injects it here
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection : setDependency1");
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection : setDependency2");
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using "+ dependency1 + " and " + dependency2;
    }
}

@Component
class YourConstructorInjection{
    Dependency1 dependency1;
    Dependency2 dependency2;

//    @Autowired // When we place autowired over a constructor, Spring searches for beans of type Dependency1 and Dependency2 and injects them here
    // Autowired is optional on constructor if there is only one constructor
    // Recommended to use Constructor Injection as all the intializations are done in one place and autowired is optional
    public YourConstructorInjection(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using "+ dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1{ }

@Component
class Dependency2{ }

@Configuration
@ComponentScan // Automatically scans the current package and its sub-packages for @Component classes
public class DepInjectionLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class))
        {
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
           System.out.println(context.getBean(YourFieldInjection.class));
           System.out.println(context.getBean(YourSetterInjection.class));
           System.out.println(context.getBean(YourConstructorInjection.class));
        }
    }
}
