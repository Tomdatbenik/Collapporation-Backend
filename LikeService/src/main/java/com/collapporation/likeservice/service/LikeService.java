package com.collapporation.likeservice.service;

import com.collapporation.likeservice.kafka.dispatcher.IDispatcher;
import com.collapporation.likeservice.repo.LikeRepo;
import com.collapporation.likeservice.event.ValidateLikeEvent;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.LikeCollection;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class LikeService {

    @Autowired
    private LikeRepo repo;

    @Value("${spring.kafka.topic}")
    String kafkaTopic;

    @Autowired
    private IDispatcher dispatcher;

    public void validateLike(Like like) {
        log.info("Start validating like object");
        log.info("Sending like validation into Kafka");
        dispatcher.dispatch("like-validation", new ValidateLikeEvent(like.getObject_id(),like.getLiked_by_id()));
    }

    public LikeCollection getLikeCollectionByObjectId(String object_id) {
        log.info("Getting like collection from repo");
        return new LikeCollection(repo.findAllByObject_id(object_id), repo.countByObjectId(object_id));
    }

    public boolean hasAlreadyLiked(String object_id, String liked_by_id)
    {
        log.info("Checking if user already liked object");
        return repo.getLikeByObjectAndLikedBy(object_id ,liked_by_id) != null;
    }

    public Like getLikeByObjectAndLikedBy(String object_id ,String liked_by_id)
    {
        log.info("Getting like object with: " + object_id + " and user: " + liked_by_id);
        return repo.getLikeByObjectAndLikedBy(object_id ,liked_by_id);
    }

    public void deleteLike(Like like)
    {
        log.info("Deleting like");
        repo.delete(like);
    }


}
