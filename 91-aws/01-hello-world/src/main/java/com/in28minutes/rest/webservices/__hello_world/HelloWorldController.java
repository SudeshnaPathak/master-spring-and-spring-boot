package com.in28minutes.rest.webservices.__hello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(){
        return """
                { "message": "Hello World Java v1" }
                """;
    }
}
