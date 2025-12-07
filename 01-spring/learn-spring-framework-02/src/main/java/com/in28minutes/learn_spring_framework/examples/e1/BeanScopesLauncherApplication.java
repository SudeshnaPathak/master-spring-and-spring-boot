package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ProtoTypeClass{

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class))
        {
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            //By default, all the beans in Spring are Singleton scoped
            //Singleton Scope - One object instance per Spring IoC container(Very Frequently used)
            //Stateless beans are usually Singleton scoped
            System.out.println(context.getBean(ProtoTypeClass.class));
            System.out.println(context.getBean(ProtoTypeClass.class));
            System.out.println(context.getBean(ProtoTypeClass.class));
            //Prototype Scope - Possibly many object instances per Spring IoC container(Rarely used)
            //Stateful beans are usually Prototype scoped
            //Output:
//            com.in28minutes.learn_spring_framework.examples.e1.NormalClass@44a7bfbc
//            com.in28minutes.learn_spring_framework.examples.e1.NormalClass@44a7bfbc
//            com.in28minutes.learn_spring_framework.examples.e1.NormalClass@44a7bfbc
//            com.in28minutes.learn_spring_framework.examples.e1.ProtoTypeClass@4ef37659
//            com.in28minutes.learn_spring_framework.examples.e1.ProtoTypeClass@776b83cc
//            com.in28minutes.learn_spring_framework.examples.e1.ProtoTypeClass@37858383

            //Other Scopes - Request, Session, Application, Websocket (Used in web applications)
            // Request Scope - A new instance is created for each HTTP request
            // Session Scope - A new instance is created for each HTTP session
            // Application Scope - A single instance is created for the entire lifecycle of a web application
            // Websocket Scope - A new instance is created for each WebSocket connection

            //Java Singleton(GOF) vs Spring Singleton
            //Spring Singleton - One instance per Spring IoC container
            //Java Singleton(GOF) - One instance per JVM

            //If we use a single IOC container inside JVM then both are same
        }
    }
}
