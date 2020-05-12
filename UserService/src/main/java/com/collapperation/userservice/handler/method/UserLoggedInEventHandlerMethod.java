package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.UserLoggedInEvent;
import com.collapperation.userservice.handler.HandlerMethod;
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
        userRepo.updateBasicUserInfo(
                event.getPicture(),
                event.getUsername(),
                event.getUuid());
    }
}
