package com.collapporation.projectservice.kafka;

import com.collapporation.projectservice.event.Event;
import com.collapporation.projectservice.handler.EventHandler;
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
}
