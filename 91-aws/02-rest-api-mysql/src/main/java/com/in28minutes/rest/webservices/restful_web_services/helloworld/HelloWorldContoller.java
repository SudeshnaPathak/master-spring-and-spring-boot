package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldContoller {

    private final MessageSource messageSource;

    public HelloWorldContoller(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //#CHANGE : Health Check Endpoint for AWS Elastic Beanstalk
    @GetMapping("/")
    public String healthCheck() {
        return "Application Running!";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    //HelloWorldBean ---> JSON
    //using @ResponseBody (automatically added with @RestController) & JacksonHttpMessageConverter which converts the object to JSON , it is auto configured by Spring Boot
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    //Path Parameters
    //hello-world/path-variable/Sudeshna
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    //Internationalization
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale(); //gets the locale of the request based on Accept-Language Header sent by the client
        return messageSource.getMessage("good.morning.message", null, "Default Message" ,locale);
    }
}
