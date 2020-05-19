package com.collapporation.likeservice.kafka;


import com.collapporation.likeservice.event.Event;
import com.collapporation.likeservice.kafka.dispatcher.IDispatcher;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaProducer implements IDispatcher {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @Override
    public void dispatch(String topic, Event event) {
        kafkaTemplate.send(topic, event);
    }
}
