package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.UserLoggedInEvent;
import com.collapperation.userservice.handler.HandlerMethod;
import com.collapperation.userservice.model.User;
import com.collapperation.userservice.repo.UserRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UserLoggedInEventHandlerMethod extends HandlerMethod<UserLoggedInEvent> {
    private final UserRepo userRepo;

    public UserLoggedInEventHandlerMethod(UserRepo userRepo) {
        super(UserLoggedInEvent.class);
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void handle(UserLoggedInEvent event) {
        System.out.println(userRepo.findById(event.getUuid()).isEmpty());

        if(userRepo.findById(event.getUuid()).isEmpty())
        {
            User user = new User();
            user.setId(event.getUuid());
            user.setUsername(event.getUsername());
            user.setFirstName(event.getFirstName());
            user.setLastName(event.getLastName());
            user.setPicture(event.getPicture());

            userRepo.save(user);
        }
    }
}
