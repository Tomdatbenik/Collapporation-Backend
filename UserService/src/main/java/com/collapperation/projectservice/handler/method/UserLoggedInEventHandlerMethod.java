package com.collapperation.projectservice.handler.method;

import com.collapperation.projectservice.event.UserLoggedInEvent;
import com.collapperation.projectservice.handler.HandlerMethod;
import com.collapperation.projectservice.model.User;
import com.collapperation.projectservice.repo.UserRepo;
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
    public void handle(UserLoggedInEvent event) {
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
