package com.collapperation.tokenservice.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TokenGenerator implements TokenBuilder {
    @Value("${collapperation.token.issuer}")
    private String issuer;
    @Value("${collapperation.token.lifespan}")
    private int minutes;

    private final Algorithm algorithm;

    public TokenGenerator(@Qualifier("privateAlgorithm") Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getNewToken(String uid, String userName, String pfp) {
        return JWT.create()
                .withIssuer(issuer)
                .withJWTId(UUID.randomUUID().toString())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * minutes)))
                .withClaim("uuid", uid)
                .withClaim("userName", userName)
                .withClaim("userImage",pfp)
                .sign(algorithm);
    }
}
