package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.LikeValidatedEvent;
import com.collapporation.likeservice.event.ValidateLikeEvent;
import com.collapporation.likeservice.repo.LikeRepo;
import com.collapporation.likeservice.handler.HandlerMethod;
import com.collapporation.likeservice.models.Like;
import org.springframework.stereotype.Component;

@Component
public class ValidatedLikeEventHandlerMethod extends HandlerMethod<ValidateLikeEvent>
{
    private final LikeRepo likeRepo;

    protected ValidatedLikeEventHandlerMethod(LikeRepo likeRepo)
    {
        super(ValidateLikeEvent.class);
        this.likeRepo = likeRepo;
    }

    @Override
    public void handle(ValidateLikeEvent event)
    {
        likeRepo.save(new Like(event.getObject_id(),event.getLiked_by_id()));
    }
}
