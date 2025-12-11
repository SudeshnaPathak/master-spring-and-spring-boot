package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass()); //Default log with slf4j

    //http://localhost:8080/login?name=Sudeshna
    @RequestMapping("login-old")
    public String oldLoginPage(@RequestParam String name , ModelMap model) { // Request Param is used to extract query parameter from the URL

        //In the Controller, if we want to send data to the View , we can use Model
        model.put("name", name); // key , value

        logger.debug("Request Param is {}" , name); // Debug level log
        logger.info("Request Param is {}" , name);  // Info level log
        logger.warn("Print a warning message"); // Warn level log
        //All levels below the configured level will be logged , Example : If the level is set to Info , Warn , Error will be logged but Debug will not be logged

        return "login"; // This will map to login.jsp
    }

    @RequestMapping("login")
    public String goToLoginPage() {
        return "login";
    }
}
