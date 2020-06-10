package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.UserLoggedInEvent;
import com.collapperation.userservice.handler.HandlerMethod;
import com.collapperation.userservice.model.User;
import com.collapperation.userservice.repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Log4j2
public class UserLoggedInEventHandlerMethod extends HandlerMethod<UserLoggedInEvent> {
    private final UserRepo userRepo;

    public UserLoggedInEventHandlerMethod(UserRepo userRepo) {
        super(UserLoggedInEvent.class);
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void handle(UserLoggedInEvent event) {

        log.info("handling: " + event);
        if(userRepo.findById(event.getUuid()).isEmpty())
        {
            User user = new User();
            user.setId(event.getUuid());
            user.setUsername(event.getUsername());
            user.setFirstName(event.getFirstName());
            user.setLastName(event.getLastName());
            user.setPicture(event.getPicture());

            log.info("Saving user: " + user);
            userRepo.save(user);
            log.info("User saved");
        }
    }
}
