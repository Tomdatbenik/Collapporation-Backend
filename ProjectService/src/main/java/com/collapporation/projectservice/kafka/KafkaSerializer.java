package com.collapporation.projectservice.kafka;

import com.collapporation.projectservice.event.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

public class KafkaSerializer implements Serializer<Event> {
    private final ObjectMapper objectMapper;

    public KafkaSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    @SneakyThrows
    public byte[] serialize(String s, Event event) {
        final StringBuilder sb = new StringBuilder(event.getClass().getSimpleName());
        sb.append(".");
        sb.append(objectMapper.writeValueAsString(event));
        return sb.toString().getBytes();
    }
}
