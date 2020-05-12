package com.collapperation.userservice.kafka;

import com.collapperation.userservice.event.Event;
import com.collapperation.userservice.event.UserLoggedInEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class KafkaDeserializerTests {

    @Test
    public void constructorTest(){

        assertDoesNotThrow((Executable) KafkaDeserializer::new);

        KafkaDeserializer kafkaDeserializer = new KafkaDeserializer();
        assertThat(kafkaDeserializer).isNotNull();
    }

    @Test
    public void deserializeTest(){
        final String serializableObject = "UserLoggedInEvent.{\"uuid\":\"id\",\"username\":\"username\",\"picture\":\"picture\"}";
        KafkaDeserializer kafkaDeserializer = new KafkaDeserializer();

        assertDoesNotThrow(() -> kafkaDeserializer.deserialize("",serializableObject.getBytes()));

        Event event = kafkaDeserializer.deserialize("",serializableObject.getBytes());
        assertThat(event).isInstanceOf(UserLoggedInEvent.class);
    }
}
