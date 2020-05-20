package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.LikeValidatedEvent;
import com.collapporation.likeservice.handler.HandlerMethod;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.repo.LikeRepo;
import org.springframework.stereotype.Component;

@Component
public class ValidatedLikeEventHandlerMethod extends HandlerMethod<LikeValidatedEvent>
{
    private final LikeRepo likeRepo;

    protected ValidatedLikeEventHandlerMethod(LikeRepo likeRepo)
    {
        super(LikeValidatedEvent.class);
        this.likeRepo = likeRepo;
    }

    @Override
    public void handle(LikeValidatedEvent event)
    {
        likeRepo.save(new Like(event.getObject_id(),event.getLiked_by_id()));
    }
}
