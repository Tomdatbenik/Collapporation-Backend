package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.dispatcher.Dispatcher;
import com.collapperation.userservice.event.LikeValidatedEvent;
import com.collapperation.userservice.event.ValidateLikeEvent;
import com.collapperation.userservice.handler.HandlerMethod;
import com.collapperation.userservice.repo.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class LikeValidateEventHandleMethod extends HandlerMethod<ValidateLikeEvent> {
    private final UserRepo userRepo;
    private Dispatcher dispatcher;

    public LikeValidateEventHandleMethod(UserRepo projectRepo, Dispatcher dispatcher)
    {
        super(ValidateLikeEvent.class);
        this.userRepo = projectRepo;
        this.dispatcher = dispatcher;
    }

    @Override
    public void handle(ValidateLikeEvent event)
    {
        if(userRepo.findById(event.getObject_id()) != null)
        {
            LikeValidatedEvent likeValidatedEvent = new LikeValidatedEvent(event.getObject_id(),event.getLiked_by_id());

            dispatcher.dispatch("like-validation", likeValidatedEvent);
        }
    }
}
