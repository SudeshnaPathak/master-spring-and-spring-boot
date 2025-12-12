package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // To store the name in session so that it can be used across multiple requests
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    public String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

// Logging Example :
//    private Logger logger = LoggerFactory.getLogger(getClass()); //Default log with slf4j
//    logger.debug("Request Param is {}" , name); // Debug level log
//    logger.info("Request Param is {}" , name);  // Info level log
//    logger.warn("Print a warning message"); // Warn level log
//    All levels below the configured level will be logged , Example : If the level is set to Info , Warn , Error will be logged but Debug will not be logged