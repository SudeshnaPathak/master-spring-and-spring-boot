package com.in28minutes.learn_spring_security.resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODOS_LIST = List.of(
            new Todo("Sudeshna", "Learn Spring Security"),
            new Todo("Sudeshna", "Learn Microservices"),
            new Todo("Sudeshna", "Learn Spring Boot")
    );

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    //Use @EnableMethodSecurity in Security Configuration to enable method level security, i.e. @PreAuthorize and @PostAuthorize
    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == authentication.name")
    @RolesAllowed({"ADMIN" , "USER"}) //Set jsr250Enabled = true in @EnableMethodSecurity to use @RolesAllowed
    @Secured({"ROLE_USER" , "ROLE_ADMIN"}) //Set securedEnabled = true in @EnableMethodSecurity to use @Secured , it checks AUTHORITIES not ROLES
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username , @RequestBody Todo todo) {
        logger.info("Creating {} for {}", todo , username);
    }
}

record Todo (String username , String Description){}