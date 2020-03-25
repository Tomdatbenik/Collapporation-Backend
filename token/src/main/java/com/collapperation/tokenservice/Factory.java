package com.collapperation.tokenservice;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
public class Factory {

    @Bean
    public JwtBuilder jwtBuilder(){
        return Jwts.builder();
    }

    @Bean("privateKey")
    public Key privateKey(){
        return null;
    }

    @Bean("publicKey")
    public Key publicKey(){
        return null;
    }

}
