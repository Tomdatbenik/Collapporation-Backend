package com.collapporation.likeservice.handler;


import com.collapporation.likeservice.event.Event;
import com.collapporation.likeservice.event.LikeValidatedEvent;
import com.collapporation.likeservice.event.ValidateLikeEvent;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.repo.LikeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {"/test/like.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EventHandlerTests
{
    @Autowired
    private EventHandler eventHandler;

    @Autowired
    private LikeRepo repo;

    @Test
    @Transactional
    void processEventTest(){
        eventHandler.processEvent((new LikeValidatedEvent("5","6")));
        final Like like = repo.getLikeByObjectAndLikedBy("5","6");

        assertThat(like.getObject_id()).isEqualTo("5");
        assertThat(like.getLiked_by_id()).isEqualTo("6");
    }

    //Test class created for process Unkown Event Test
    private class UnknownEvent extends Event
    {

    }

    @Test
    void processUnknownEventTest() {
        assertDoesNotThrow(() -> eventHandler.processEvent(new UnknownEvent()));
    }
}
