package com.collapperation.userservice.kafka;

import com.collapperation.userservice.dispatcher.Dispatcher;
import com.collapperation.userservice.event.Event;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaDispatcher implements Dispatcher {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @Override
    public void dispatch(String topic, Event event) {
        kafkaTemplate.send(topic, event);
    }
}
