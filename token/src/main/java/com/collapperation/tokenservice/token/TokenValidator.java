package com.collapperation.tokenservice.token;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public interface TokenValidator {
    DecodedJWT verify(String token);
}
