package com.collapperation.userservice.kafka;

import com.collapperation.userservice.events.Event;
import com.collapperation.userservice.handler.EventHandler;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {
    private final EventHandler eventHandler;

    @KafkaListener(topics = "user", groupId = "${spring.application.name}")
    public void consume(Event event){
        eventHandler.processEvent(event);
    }
}
