package com.collapporation.tokenservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.collapporation.tokenservice.utils.PemUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class TokenConfig {
    @Value("${collapperation.token.privatekey}")
    private String filepath;

    @Bean("privateAlgorithm")
    public Algorithm privAlgorithm() throws IOException {
        return Algorithm.RSA512(null, (RSAPrivateKey) PemUtils.readPrivateKeyFromFile(filepath, "RSA"));
    }

    @Value("${collapperation.token.publicKey}")
    private String publicKey;

    @Bean("publicAlgorithm")
    public Algorithm pubAlgorithm() throws IOException {
        return Algorithm.RSA512((RSAPublicKey) PemUtils.readPublicKeyFromFile(publicKey, "RSA"), null);
    }

    @Value("${collapperation.token.issuer}")
    private String signer;

    @Bean
    public JWTVerifier jwtVerifier(@Qualifier("publicAlgorithm") Algorithm algorithm){
        return JWT.require(algorithm).withIssuer(signer).build();
    }
}
