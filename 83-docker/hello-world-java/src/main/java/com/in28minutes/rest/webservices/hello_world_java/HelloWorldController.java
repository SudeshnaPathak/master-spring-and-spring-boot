package com.in28minutes.rest.webservices.hello_world_java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String HelloWorld() {
        return  """
                { message: Hello World Java v1 }
               """;
    }
}
