package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.LikeCreatedEvent;
import com.collapporation.likeservice.handler.HandlerMethod;
import com.collapporation.likeservice.repo.LikeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class CreateLikeEventHandlerMethod extends HandlerMethod<LikeCreatedEvent>
{
    private final LikeRepo likeRepo;

    protected CreateLikeEventHandlerMethod(LikeRepo likeRepo)
    {
        super(LikeCreatedEvent.class);
        this.likeRepo = likeRepo;
    }

    @Override
    public void handle(LikeCreatedEvent event)
    {
        likeRepo.save(event.getLike());
    }
}
