package com.collapperation.tokenservice.controller;

import com.collapperation.tokenservice.generator.TokenGenerator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@AllArgsConstructor
public class TokenController {
    private final TokenGenerator tokenGenerator;

    @GetMapping("/new")
    public ResponseEntity<String> newToken(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refreshToken(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
