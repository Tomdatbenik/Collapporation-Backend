package com.collapporation.likeservice.repo;

import com.collapporation.likeservice.models.Like;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/like.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LikeRepoTests
{
    @Autowired
    private LikeRepo repo;

    @Test
    @Transactional
    void getCountTest() {
        long count = repo.countByObjectId("1");

        assertThat(count).isEqualTo(2);
    }

    @Test
    @Transactional
    void getLikeByObjectAndByLikeIdTest() {
        final Like like = repo.getLikeByObjectAndLikedBy("1","2");

        assertThat(like).isNotNull();
        assertThat(like.getObject_id()).isEqualTo("1");
        assertThat(like.getLiked_by_id()).isEqualTo("2");
    }

}
