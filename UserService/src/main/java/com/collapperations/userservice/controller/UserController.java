package com.collapperations.userservice.controller;

import com.collapperations.userservice.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUser() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
