package com.in28minutes.learn_oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/")
    public String helloWorld(Authentication authentication) {
        logger.info("Authentication Details: {}", authentication.getPrincipal());
        return "Hello World!";
    }
}

//Authentication Details: Name: [102674409642991142495], Granted Authorities: [[OIDC_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email,
// name=Sudeshna Pathak, exp=2026-01-06T12:12:27Z, family_name=Pathak, iat=2026-01-06T11:12:27Z, email=pathaksudeshna92@gmail.com}]
