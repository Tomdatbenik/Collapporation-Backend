package com.collapperation.userservice.handler;

import com.collapperation.userservice.events.Event;
import com.collapperation.userservice.events.UserLoggedInEvent;
import com.collapperation.userservice.models.User;
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
    @Override
    public void handle(Event event) {
        UserLoggedInEvent userLoggedInEvent = (UserLoggedInEvent) event;
        userRepo.save(new User(
                userLoggedInEvent.getUuid(),
                userLoggedInEvent.getUserName(),
                userLoggedInEvent.getFirstName(),
                userLoggedInEvent.getLastName(),
                null,
                userLoggedInEvent.getPicture()));
    }
}
