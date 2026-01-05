package com.in28minutes.learn_spring_security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class JwtSecurityConfiguration {

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

        //Enabling Basic Authentication
        http.httpBasic(withDefaults());

        //Disabling CSRF Protection
        http.csrf(
                csrf -> csrf.disable()
        );

        http.headers(headers ->
                headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.sameOrigin())); //To Enable H2 Console

        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults())); //Enabling JWT Authentication

        return http.build();

    }


    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2) //Sets the database type to H2
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION) //Adds the default user schema script provided by Spring Security
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        UserDetails user = User.withUsername("Sudeshna")
                .password("dummy")
                .passwordEncoder(str -> passwordEncoder().encode(str)) //Encoding the password using BCryptPasswordEncoder
                .roles(Role.USER.name())
                .build();

        UserDetails admin = User.withUsername("admin")
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

    //1.Create Key Pair
    @Bean
    public KeyPair keyPair(){
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); //Using RSA Algorithm for Key Pair Generation
            keyPairGenerator.initialize(2048); //Key Size of 2048 bits
            return keyPairGenerator.generateKeyPair(); //Generating the Key Pair
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    //2.Create RSA Key using the Key Pair
    @Bean
    public RSAKey rsaKey(KeyPair keyPair){
        return new RSAKey
                .Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair().getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    //3.Create JWK Source(JSON Web Key Source) using the RSA Key
    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey){
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector , securityContext) -> jwkSelector.select(jwkSet);
//        JWKSource jwkSource = new JWKSource() {
//
//            @Override
//            public List<JWK> get(JWKSelector jwkSelector, SecurityContext securityContext) throws KeySourceException {
//                return jwkSelector.select(jwkSet);
//            }
//        };
    }

    //4.Create JWT Decoder using the RSA Key -> To use RSA Public key for Decoding the JWT Token
    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
        return NimbusJwtDecoder
                .withPublicKey(rsaKey.toRSAPublicKey())
                .build();

    }


}
