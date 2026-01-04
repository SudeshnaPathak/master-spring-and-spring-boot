package com.in28minutes.learn_spring_security.resources;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityPlayResource {

    //To generate and retrieve CSRF token for Synchronizer Token Pattern, to be used in POST, PUT, DELETE requests
    @GetMapping("/csrf-token")
    public CsrfToken retrieveCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
