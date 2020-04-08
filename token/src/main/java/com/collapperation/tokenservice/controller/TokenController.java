package com.collapperation.tokenservice.controller;

import com.collapperation.tokenservice.token.TokenBuilder;
import com.collapperation.tokenservice.token.TokenGenerator;
import com.collapperation.tokenservice.token.TokenValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController {
    private final TokenBuilder tokenBuilder;
    private final TokenValidator tokenValidator;

    @GetMapping("/new")
    public ResponseEntity<String> newToken(@RequestHeader("idToken") String idToken){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refreshToken(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
