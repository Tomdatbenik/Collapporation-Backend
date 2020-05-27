package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.LikeValidatedEvent;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.repo.LikeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Sql(scripts = {"/test/like.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ValidatedLikeEventHandlerMethodTests
{
    @Autowired
    private LikeRepo repo;

    @Test
    void allArgsConstructorTest()
    {
        assertDoesNotThrow(() -> {
            new ValidatedLikeEventHandlerMethod(repo);
        });
    }

    @Test
    void handlingTypeTest() {
        final ValidatedLikeEventHandlerMethod validatedLikeEventHandlerMethod = new ValidatedLikeEventHandlerMethod(repo);

        assertThat(validatedLikeEventHandlerMethod).isNotNull();
        assertThat(validatedLikeEventHandlerMethod.getHandlingType()).isEqualTo(LikeValidatedEvent.class);
    }

    @Test
    @Transactional
    void saveLikeTest()
    {
        final ValidatedLikeEventHandlerMethod validatedLikeEventHandlerMethod = new ValidatedLikeEventHandlerMethod(repo);

        validatedLikeEventHandlerMethod.handle(new LikeValidatedEvent("2", "3"));

        final Like like = repo.getLikeByObjectAndLikedBy("2", "3");

        assertThat(like).isNotNull();
        assertThat(like.getObject_id()).isEqualTo("2");
        assertThat(like.getLiked_by_id()).isEqualTo("3");
    }
}
