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

    // JSP View - Java Server Pages
    // src/main/resourcses/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // say-hello-jsp -> SayHelloController -> sayHelloJsp() -> sayHello
    // ViewResolver -> Prefix + sayHello + Suffix
    // Prefix = /WEB-INF/jsp/
    // Suffix = .jsp
    // Specified in application.properties
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello"; // This will map to sayHello.jsp
    }
}
