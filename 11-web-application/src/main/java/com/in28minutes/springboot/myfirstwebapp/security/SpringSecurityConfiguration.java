package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //LDAP or Database or InMemory Authentication

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        UserDetails userDetails1 = CreateNewUser("in28minutes", "dummy");
        UserDetails userDetails2 = CreateNewUser("Sudeshna", "dummy1");

        //InMemoryUserDetailsManager(UserDetails... users) ~Constructor
        return new InMemoryUserDetailsManager(userDetails1 , userDetails2);
    }

    private UserDetails CreateNewUser(String username, String password) {
        Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input);
        //Takes a string as input and returns the encoded string as output
        //Here passwordEncoder function encodes the password while creating the userDetails object

        //Custom User Details Object
        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
