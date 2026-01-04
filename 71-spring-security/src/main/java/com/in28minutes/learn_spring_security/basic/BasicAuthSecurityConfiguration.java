package com.in28minutes.learn_spring_security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    //Storing User Credentials in In-Memory Database(Not Recommended for Production)
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("Sudeshna")
                .password("{noop}dummy") //{noop} means NoOpPasswordEncoder is used which does not perform any encoding
                .roles(Role.USER.name())
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}dummy")
                .roles(Role.ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(user , admin);
    }

}
