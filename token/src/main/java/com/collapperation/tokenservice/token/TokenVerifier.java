package com.collapperation.tokenservice.token;


import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

@Component
public class TokenVerifier implements TokenValidator {
    private final JWTVerifier jwtVerifier;

    public TokenVerifier(JWTVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    private String removePrefix(String token) {
        return token.replace("Bearer ", "");
    }

    public DecodedJWT verify(String token) {
        return jwtVerifier.verify(removePrefix(token));
    }
}
