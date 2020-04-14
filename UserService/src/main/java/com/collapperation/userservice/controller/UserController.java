package com.collapperation.userservice.controller;

import com.collapperation.userservice.models.User;
import com.collapperation.userservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepo userRepo;

    //TODO Make it so other users can't get private details form other users.
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUser(@PathVariable("userid") String userId) {
        final User user = userRepo.findById(userId).orElse(null);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
