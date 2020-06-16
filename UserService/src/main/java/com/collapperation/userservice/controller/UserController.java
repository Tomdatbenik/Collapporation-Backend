package com.collapperation.userservice.controller;

import com.collapperation.userservice.model.User;
import com.collapperation.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Log4j2
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        log.info("Received: " + userId);
        final User user = userService.getUser(userId);
        if(user == null){
            log.info("Not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("returning");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
