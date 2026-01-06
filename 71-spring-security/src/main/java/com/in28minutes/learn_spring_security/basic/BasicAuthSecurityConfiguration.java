package com.in28minutes.learn_spring_security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true , securedEnabled = true)
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //All Requests should be authenticated
        http.authorizeHttpRequests(
                auth -> {
                    auth
                            .requestMatchers("/users/**").hasRole("USER")
                            .anyRequest().authenticated();
                }
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

        http.headers(headers ->
                headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable())); //To Enable H2 Console

        return http.build();

    }

    //Storing User Credentials in In-Memory Database(Not Recommended for Production)
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("Sudeshna")
//                .password("{noop}dummy") //{noop} means NoOpPasswordEncoder is used which does not perform any encoding
//                .roles(Role.USER.name())
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}dummy")
//                .roles(Role.ADMIN.name())
//                .build();
//        return new InMemoryUserDetailsManager(user , admin);
//    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2) //Sets the database type to H2
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION) //Adds the default user schema script provided by Spring Security
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        //Challenge : Password is stored in Unencrypted Format
        UserDetails user = User.withUsername("Sudeshna")
//                .password("{noop}dummy") //{noop} means NoOpPasswordEncoder is used which does not perform any encoding
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str)) //Encoding the password using BCryptPasswordEncoder
                .roles(Role.USER.name())
                .build();

        UserDetails admin = User.withUsername("admin")
//                .password("{noop}dummy")
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(Role.ADMIN.name() , Role.USER.name())
                .build();
        //Roles are stored as Authority with "ROLE_" prefix in the database

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
