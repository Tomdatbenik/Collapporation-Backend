package com.collapporation.likeservice.dto;

import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.dto.LikeDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeDTOTests {
    @Test
    public void noArgsContructorTest()
    {
        final LikeDto like = new LikeDto();

        assertThat(like.getLiked_by_id()).isNull();
        assertThat(like.getObject_id()).isNull();
    }

    @Test
    void allArgsContructorTest()
    {
        final LikeDto like = new LikeDto("2", "3");

        assertThat(like.getObject_id()).isEqualTo("2");
        assertThat(like.getLiked_by_id()).isEqualTo("3");
    }

    @Test
    void likeDTOContructorTest()
    {
        final Like like = new Like("1", "2");

        final LikeDto likeDto = new LikeDto(like);

        assertThat(likeDto.getLiked_by_id()).isEqualTo(like.getLiked_by_id());
        assertThat(likeDto.getObject_id()).isEqualTo(like.getObject_id());
    }

//    @Test
//    public void equalsTest()
//    {
//        final LikeDto likeDTOA = new LikeDto();
//        final LikeDto likeDTOB = new LikeDto();
//
//        assertThat(likeDTOA).isEqualTo(likeDTOB);
//    }

    @Test
    void notEqualTest() {
        final LikeDto likeDTOA = new LikeDto();
        final LikeDto likeDTOB = new LikeDto();

        likeDTOA.setObject_id("different id than likeA");

        assertThat(likeDTOA).isNotEqualTo(likeDTOB);
    }
}
