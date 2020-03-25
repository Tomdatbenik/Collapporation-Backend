package com.collapperation.tokenservice.generator;

import io.jsonwebtoken.JwtBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenGenerator {
    @Value("${collapporation.token.issuer")
    private String issuer;
    @Value("${collapperation.token.lifespan}")
    private int minutes;



    private final JwtBuilder jwtBuilder;
    private final Key key;

    public TokenGenerator(                         final JwtBuilder jwtBuilder,
                          @Qualifier("privateKey") final Key key){
        this.jwtBuilder = jwtBuilder;
        this.key = key;
    }

    public String newToken(){
        return jwtBuilder
                .setIssuer(issuer)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * minutes)))

                .signWith(key)
                .compact();
    }
}
