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
    //InMemoryUserDetailsManager(UserDetails... users) ~Constructor

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input); //Lambda function to encode password, Whatever input is given to this function it will return the encoded password
        //Takes a string as input and returns the encoded string as output
        //Here we are using the passwordEncoder function to encode the password while creating the userDetails object

        //Custom User Details Object
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("in28minutes")
                .password("dummy")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
