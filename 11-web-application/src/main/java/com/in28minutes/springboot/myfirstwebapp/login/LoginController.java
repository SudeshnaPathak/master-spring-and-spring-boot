package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    //http://localhost:8080/login?name=Sudeshna
    @RequestMapping("login")
    public String goToLoginPage(@RequestParam String name , ModelMap model) { // Request Param is used to extract query parameter from the URL
        //In the Controller , if we want to send data to the View , we can use Model
        model.put("name", name); // key , value
        System.out.println("Request Param is " + name); //NOT for Production Code
        return "login"; // This will map to login.jsp
    }
}
