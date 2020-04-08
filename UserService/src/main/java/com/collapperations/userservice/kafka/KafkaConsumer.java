package com.collapperations.userservice.kafka;

import com.collapperations.userservice.events.Event;
import com.collapperations.userservice.handler.EventHandler;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {
    private final EventHandler eventHandler;

    @KafkaListener(topics = "user", groupId = "${spring.apllication.name}")
    public void consume(Event event){
        eventHandler.processEvent(event);
    }
}
