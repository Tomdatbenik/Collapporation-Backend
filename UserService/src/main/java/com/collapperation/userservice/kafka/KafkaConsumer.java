package com.collapperation.userservice.kafka;

import com.collapperation.userservice.event.Event;
import com.collapperation.userservice.handler.EventHandler;
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

    @KafkaListener(topics = "user", groupId = "${spring.application.name}")
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
