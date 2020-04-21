package com.collapperation.userservice.kafka;

import com.collapperation.userservice.event.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class KafkaDeserializer implements Deserializer<Event> {
    private final String eventFolder = "com.collapperation.userservice.events.";

    private final ObjectMapper objectMapper;

    public KafkaDeserializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    @SneakyThrows
    public Event deserialize(String s, byte[] bytes) {
        final String data = new String(bytes);
        final String[] dataSplit = data.split("\\.", 2);
        return (Event) objectMapper.readValue(dataSplit[1], Class.forName(eventFolder + dataSplit[0]));
    }
}
