package com.in28minutes.springboot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // to define a controller and to handle HTTP requests
public class CurrencyConfigurationController {

    //Field Injection
    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration") // to map HTTP requests to handler methods of MVC and REST controllers
    public CurrencyServiceConfiguration retrieveCurrencyConfiguration()
    {
        return configuration;
    }
}
