package com.collapporation.likeservice.service;

import com.collapporation.likeservice.event.LikeCreatedEvent;
import com.collapporation.likeservice.kafka.dispatcher.IDispatcher;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.LikeCollection;
import com.collapporation.likeservice.repo.LikeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepo repo;

    @Value("${spring.kafka.topic}")
    String kafkaTopic;

    @Autowired
    private IDispatcher dispatcher;

    public void createLike(Like like) {
        dispatcher.dispatch(kafkaTopic, new LikeCreatedEvent(like));
    }

    public LikeCollection getLikeCollectionByObjectId(String object_id) {
        return new LikeCollection(null, 0);
    }


}
