package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContoller {

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
}
