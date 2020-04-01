package com.collapperation.tokenservice.generator;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TokenGenerator {
    @Value("${collapporation.token.issuer")
    private String issuer;
    @Value("${collapperation.token.lifespan}")
    private int minutes;

    private final Algorithm algorithm;
    public TokenGenerator(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public String newToken(){
        return JWT.create()
                .withIssuer(issuer)
                .withJWTId(UUID.randomUUID().toString())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * minutes)))
                .sign(algorithm);
    }
}
