package com.collapperation.tokenservice.validator;


import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

@Component
public class TokenValidator {
    private final JWTVerifier jwtVerifier;

    public TokenValidator(JWTVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    private String removePrefix(String token){
        return token.replace("Bearer ","");
    }

    private DecodedJWT verify(String token){
        return jwtVerifier.verify(removePrefix(token));
    }

    public boolean validate(String token){
        try {
            verify(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Claim getClaim(String token, String claimName){
        return verify(token).getClaim(claimName);
    }
}
