package com.collapporation.likeservice.service;

import com.collapporation.likeservice.event.LikeCreatedEvent;
import com.collapporation.likeservice.kafka.dispatcher.IDispatcher;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.repo.LikeRepo;
import lombok.AllArgsConstructor;
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

    public void createLike(Like like)
    {
        dispatcher.dispatch(kafkaTopic, new LikeCreatedEvent(like));
    }


}
