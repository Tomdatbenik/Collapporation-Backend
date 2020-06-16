package com.collapporation.projectservice.token;

import com.auth0.jwt.interfaces.DecodedJWT;

public interface TokenValidator {
    DecodedJWT verify(String token);
}
