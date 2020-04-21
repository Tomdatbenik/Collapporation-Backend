package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.Event;
import com.collapperation.userservice.event.UserLoggedInEvent;
import com.collapperation.userservice.handler.HandlerMethod;
import com.collapperation.userservice.model.User;
import com.collapperation.userservice.repo.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserLoggedInEventHandlerMethod extends HandlerMethod<UserLoggedInEvent> {
    private final UserRepo userRepo;

    public UserLoggedInEventHandlerMethod(UserRepo userRepo){
        super(UserLoggedInEvent.class);
        this.userRepo = userRepo;
    }


    //TODO make user events convertible to user
    //TODO is broken, fix this
    @Override
    public void handle(UserLoggedInEvent event) {
        UserLoggedInEvent userLoggedInEvent = (UserLoggedInEvent) event;
//        userRepo.save(new User(
//                userLoggedInEvent.getUuid(),
//                userLoggedInEvent.getUserName(),
//                null,
//                userLoggedInEvent.getPicture()));
    }
}
