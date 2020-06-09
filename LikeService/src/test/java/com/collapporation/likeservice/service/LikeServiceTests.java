package com.collapporation.likeservice.service;

import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.LikeCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/like.sql")
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LikeServiceTests
{
    @Autowired
    private LikeService service;

    @Test
    void getLikeByObjectAndLikedByTest()
    {
        final Like like = service.getLikeByObjectAndLikedBy("1", "2");

        assertThat(like).isNotNull();
        assertThat(like.getObject_id()).isEqualTo("1");
        assertThat(like.getLiked_by_id()).isEqualTo("2");
    }

    @Test
    void getLikeCollection()
    {
        final LikeCollection likeCollection = service.getLikeCollectionByObjectId("1");

        assertThat(likeCollection.getLikeList().size()).isEqualTo(2);
        assertThat(likeCollection.getCount()).isEqualTo(2);
    }

    @Test
    void hasAlreadyLikedIsTrueTest()
    {
        final boolean result = service.hasAlreadyLiked("1", "2");

        assertThat(result).isTrue();
    }

    @Test
    void hasAlreadyLikedIsFalseTest()
    {
        final boolean result = service.hasAlreadyLiked("5", "5");

        assertThat(result).isFalse();
    }
}
