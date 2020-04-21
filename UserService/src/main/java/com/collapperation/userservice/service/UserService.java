package com.collapperation.userservice.service;

import com.collapperation.userservice.model.User;
import com.collapperation.userservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User getUser(String id){
        return userRepo.findById(id).orElse(null);
    }
}
