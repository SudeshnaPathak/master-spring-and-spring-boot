package com.in28minutes.rest.webservices.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //Overriding the existing Filter Chain

        //3 Default Security Features:
        //1.All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/").permitAll() //#CHANGE: Allowing access to the root URL for health check during deployment
                        .anyRequest().authenticated()
        );

        //2.If not, provide a web form to login
        http.httpBasic(withDefaults()); //Here, Basic Authentication ~ Browser shows a pop-up to enter username and password
        //We don't want a web form, so we use Basic Authentication

        //3.CSRF enabled ~ Which impacts POST , PUT , DELETE requests(401 Unauthorized errors)
        http.csrf(AbstractHttpConfigurer::disable); //Here, Disabling CSRF for simplicity
        //OR
//        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
