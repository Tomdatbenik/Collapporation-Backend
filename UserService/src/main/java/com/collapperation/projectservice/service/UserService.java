package com.collapperation.projectservice.service;

import com.collapperation.projectservice.model.User;
import com.collapperation.projectservice.repo.UserRepo;
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
