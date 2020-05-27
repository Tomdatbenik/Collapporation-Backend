package com.collapporation.likeservice.models;

import com.collapporation.likeservice.models.dto.LikeDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeTests {
    @Test
    void noArgsContructorTest()
    {
        final Like like = new Like();

        assertThat(like.getLiked_by_id()).isNull();
        assertThat(like.getId()).isNull();
        assertThat(like.getObject_id()).isNull();
    }

    @Test
    void allArgsContructorTest()
    {
        final Like like = new Like("1", "2", "3");

        assertThat(like.getId()).isEqualTo("1");
        assertThat(like.getObject_id()).isEqualTo("2");
        assertThat(like.getLiked_by_id()).isEqualTo("3");
    }

    @Test
    void likeDTOContructorTest()
    {
        final LikeDto likeDto = new LikeDto("1", "2");

        final Like like = new Like(likeDto);

        assertThat(like.getLiked_by_id()).isEqualTo(likeDto.getLiked_by_id());
        assertThat(like.getObject_id()).isEqualTo(likeDto.getObject_id());
    }

    @Test
    void equalsTest()
    {
        final Like likeA = new Like();
        final Like likeB = new Like();

        assertThat(likeA).isEqualTo(likeB);
    }

    @Test
    void notEqualTest() {
        final Like likeA = new Like();
        final Like likeB = new Like();

        likeA.setId("different id than likeB");

        assertThat(likeA).isNotEqualTo(likeB);
    }
}
