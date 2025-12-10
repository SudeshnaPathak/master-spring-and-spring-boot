package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // To define a controller which can handle HTTP requests
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody // To indicate that the return value should be used as the response body
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My First HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My First HTML Page with Body - Changed");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
}
