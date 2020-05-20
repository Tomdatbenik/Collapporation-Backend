package com.collapporation.likeservice.service;

import com.collapporation.likeservice.event.ValidateLikeEvent;
import com.collapporation.likeservice.kafka.dispatcher.IDispatcher;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.LikeCollection;
import com.collapporation.likeservice.repo.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepo repo;

    @Value("${spring.kafka.topic}")
    String kafkaTopic;

    @Autowired
    private IDispatcher dispatcher;

    public void validateLike(Like like) {
        dispatcher.dispatch("like-validation", new ValidateLikeEvent(like.getObject_id(),like.getLiked_by_id()));
    }

    public LikeCollection getLikeCollectionByObjectId(String object_id) {
        return new LikeCollection(repo.findAllByObject_id(object_id), repo.countByObjectId(object_id));
    }

    public boolean hasAlreadyLiked(String id)
    {
        return !repo.findAllByLiked_By_Id(id).isEmpty();
    }

    public Like getLikeByObjectAndLikedBy(String object_id ,String liked_by_id)
    {
        return repo.getLikeByObjectAndLikedBy(object_id ,liked_by_id);
    }

    public void deleteLike(Like like)
    {
        repo.delete(like);
    }


}
