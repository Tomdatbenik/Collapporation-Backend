package com.collapporation.likeservice.kafka;

import com.collapporation.likeservice.event.Event;
import com.collapporation.likeservice.handler.EventHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private final EventHandler eventHandler;

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.application.name}")
    public void consume(Event event){
        logger.info("received event");
        eventHandler.processEvent(event);
    }

    @KafkaListener(topics = "like-validation", groupId = "${spring.application.name}")
    public void consumeLikeValidation(Event event){
        logger.info("received event from like-validation topic");
        eventHandler.processEvent(event);
    }
}
