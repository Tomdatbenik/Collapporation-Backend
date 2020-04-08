package com.collapperation.tokenservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static com.collapperation.tokenservice.utils.PemUtils.readPrivateKeyFromFile;
import static com.collapperation.tokenservice.utils.PemUtils.readPublicKeyFromFile;

@Configuration
public class TokenConfig {
    @Value("${collapperation.token.privatekey}")
    private String filepath;

    @Bean("privateAlgorithm")
    public Algorithm privAlgorithm() throws IOException {
        return Algorithm.RSA512(null, (RSAPrivateKey) readPrivateKeyFromFile(filepath, "RSA"));
    }

    @Value("${collaperation.token.publicKey}")
    private String publicKey;

    @Bean("publicAlgorithm")
    public Algorithm pubAlgorithm() throws IOException {
        return Algorithm.RSA512((RSAPublicKey) readPublicKeyFromFile(publicKey, "RSA"), null);
    }

    @Value("${collapperation.token.signer}")
    private String signer;

    @Bean
    public JWTVerifier jwtVerifier(@Qualifier("publicAlgorithm") Algorithm algorithm){
        return JWT.require(algorithm).withIssuer(signer).build();
    }
}
