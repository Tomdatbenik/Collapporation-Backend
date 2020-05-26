package com.collapporation.projectservice.handler.method;



import com.collapporation.projectservice.event.LikeValidatedEvent;
import com.collapporation.projectservice.event.ValidateLikeEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.kafka.dispatcher.IDispatcher;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.stereotype.Component;

@Component
public class LikeValidateEventHandleMethod extends HandlerMethod<ValidateLikeEvent> {
    private final ProjectRepo projectRepo;
    private IDispatcher dispatcher;

    public LikeValidateEventHandleMethod(ProjectRepo projectRepo,IDispatcher dispatcher)
    {
        super(ValidateLikeEvent.class);
        this.projectRepo = projectRepo;
        this.dispatcher = dispatcher;
    }

    @Override
    public void handle(ValidateLikeEvent event)
    {
        if(projectRepo.findById(event.getObject_id()).orElse(null) != null)
        {
            LikeValidatedEvent likeValidatedEvent = new LikeValidatedEvent(event.getObject_id(),event.getLiked_by_id());

            dispatcher.dispatch("like-validation", likeValidatedEvent);
        }
    }
}
