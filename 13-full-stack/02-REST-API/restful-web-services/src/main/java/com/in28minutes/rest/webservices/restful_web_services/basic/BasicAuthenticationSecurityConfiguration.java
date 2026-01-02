package com.in28minutes.rest.webservices.restful_web_services.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration //Very Important otherwise, Spring Security Configuration will not be applied
// & you will see default Spring Security behavior
public class BasicAuthenticationSecurityConfiguration {
    //Filter Chain
    //HttpSecurity is used to configure security for HTTP requests by customizing filter chains.

    //By default:
    //1. All endpoints are authenticated
    //2. A login form is shown for authentication
    //3. CSRF protection is enabled

    //Stateless Rest APIs do not use sessions to store user state.
    //So, we disable CSRF protection and form login.
    //We can use Basic Authentication for stateless APIs.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests(
                    auth ->
                                auth
                                 .requestMatchers(HttpMethod.OPTIONS , "/**").permitAll() //To enable CORS Pre-Flight Requests
                                 .anyRequest().authenticated()
                                )
                    .httpBasic(withDefaults())
                    .sessionManagement(
                    session -> session.sessionCreationPolicy(
                            SessionCreationPolicy.STATELESS))
                    .csrf(AbstractHttpConfigurer::disable)
                    .build();
    }
}
