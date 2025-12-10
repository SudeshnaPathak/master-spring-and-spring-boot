package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // To define a controller which can handle HTTP requests
public class SayHelloController {
    //say-hello -> "Hello! What are you learning today?"

    @RequestMapping("say-hello")
    @ResponseBody // To indicate that the return value should be used as the response body
    public String sayHello() {
        return "Hello! What are you learning today?";
    }
}
