package com.collapporation.tokenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TokenServiceApplication {

	public static void main(String[] args) {
		java.security.Security.addProvider(
				new org.bouncycastle.jce.provider.BouncyCastleProvider()
		);

		SpringApplication.run(TokenServiceApplication.class, args);
	}

}
