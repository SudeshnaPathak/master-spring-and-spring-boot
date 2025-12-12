package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

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

    //Spring Security Filter Chain(Default Configuration):-
    //All URLs are secured by default in Spring Security
    //A login form is shown for unauthenticated users
    //CSRF protection is enabled by default ~ disable it
    //Frames are disabled by default

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Here we can customize the default security filter chain by Overriding the default configuration
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()); //All requests need to be authenticated
        http.formLogin(withDefaults()); //Default Login Form

        http.csrf(AbstractHttpConfigurer::disable); //Disable CSRF Protection

        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)); //To enable H2 Console which uses frames

        return http.build();
    }
}
