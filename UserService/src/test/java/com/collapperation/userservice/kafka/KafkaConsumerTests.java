package com.collapperation.userservice.kafka;

// TODO: 12/05/2020 Embedded kafka server tests not working: java.lang.NoClassDefFoundError: Lorg/springframework/kafka/listener/RecordInterceptor

//import com.collapperation.userservice.model.User;
//import com.collapperation.userservice.repo.UserRepo;
//import org.junit.BeforeClass;
//import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//import org.springframework.kafka.test.rule.KafkaEmbedded;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

//@SpringBootTest
//@EmbeddedKafka(topics = "user", partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class KafkaConsumerTests {
//    @Autowired
//    private KafkaConsumer kafkaConsumer;
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    public KafkaTemplate<String, String> template;
//
//    @Autowired
//    public KafkaEmbedded kafkaEmbedded;
//
//    @ClassRule
//    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, 0);
//
//    @BeforeClass
//    public static void setUpClass() {
//        System.setProperty("spring.kafka.bootstrap-servers", embeddedKafka.getBrokersAsString());
//        System.setProperty("spring.cloud.stream.kafka.binder.zkNodes", embeddedKafka.getZookeeperConnectionString());
//    }

    @Test
    public void constructorTest() {
        assertDoesNotThrow(() -> {
            new KafkaConsumer(null);
        });

        KafkaConsumer kafkaConsumer = new KafkaConsumer(null);
        assertThat(kafkaConsumer).isNotNull();
    }

//    @Test
//    public void consumeTest() {
//
//
//        template.send("user", "UserLoggedInEvent.{\"uuid\":\"id\",\"username\":\"username\",\"picture\":\"picture\"}");
//        final User user = userRepo.getOne("id");
//
//        assertThat(user).isNotNull();
//        assertThat(user.getPicture()).isEqualTo("picture");
//        assertThat(user.getUsername()).isEqualTo("username");
//        assertThat(user.getId()).isEqualTo("id");
//    }
}
