package com.collapperation.tokenservice.token;

import com.auth0.jwt.interfaces.Claim;

public interface TokenValidator {
    public boolean validate(String token);

    public Claim getClaim(String token, String claimName);
}
