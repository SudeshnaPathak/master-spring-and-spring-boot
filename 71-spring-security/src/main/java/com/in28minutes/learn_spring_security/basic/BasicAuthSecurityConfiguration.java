package com.in28minutes.learn_spring_security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //All Requests should be authenticated
        http.authorizeHttpRequests(
                auth ->
                        auth.anyRequest().authenticated()
                );

        //Setting Stateless Session ~ No Sessions will be created or used by Spring Security
        http.sessionManagement(
                session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS)
                );

        //http.formLogin();  ~ Disabling Form Based Authentication

        //Enabling Basic Authentication
        http.httpBasic(withDefaults());

        //Disabling CSRF Protection
        http.csrf(
                csrf -> csrf.disable()
        );

        return http.build();

    }
}
