package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.UserLoggedInEvent;
import com.collapperation.userservice.handler.HandlerMethod;
import com.collapperation.userservice.repo.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserLoggedInEventHandlerMethod extends HandlerMethod<UserLoggedInEvent> {
    private final UserRepo userRepo;

    public UserLoggedInEventHandlerMethod(UserRepo userRepo) {
        super(UserLoggedInEvent.class);
        this.userRepo = userRepo;
    }


    //TODO is broken, fix this
    @Override
    public void handle(UserLoggedInEvent event) {
        UserLoggedInEvent userLoggedInEvent = (UserLoggedInEvent) event;
        userRepo.updateBasicUserInfo(
                userLoggedInEvent.getPicture(),
                userLoggedInEvent.getUserName(),
                userLoggedInEvent.getUuid());
    }
}
