package com.collapporation.tokenservice.kafka;

import com.collapporation.tokenservice.events.Event;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaDispatcher {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    public void dispatch(String topic, Event event) {
        kafkaTemplate.send(topic, event);
    }
}
