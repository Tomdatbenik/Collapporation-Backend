package com.collapporation.likeservice.dto;

import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.dto.LikeCountDto;
import com.collapporation.likeservice.models.dto.LikeDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeCountDTOTests {
    @Test
    public void noArgsContructorTest()
    {
        final LikeCountDto likeCountDto = new LikeCountDto();

        assertThat(likeCountDto.getCount()).isEqualTo(0);
        assertThat(likeCountDto.getObject_id()).isNull();
    }

    @Test
    public void allArgsContructorTest()
    {
        final LikeCountDto likeCountDto = new LikeCountDto("2", 1);

        assertThat(likeCountDto.getObject_id()).isEqualTo("2");
        assertThat(likeCountDto.getCount()).isEqualTo(1);
    }

//    @Test
//    public void equalsTest()
//    {
//        final LikeCountDto likeCountDtoA = new LikeCountDto();
//        final LikeCountDto likeCountDtoB = new LikeCountDto();
//
//        assertThat(likeCountDtoA).isEqualTo(likeCountDtoB);
//    }

    @Test
    public void notEqualTest() {
        final LikeCountDto likeCountDtoA = new LikeCountDto();
        final LikeCountDto likeCountDtoB = new LikeCountDto();

        likeCountDtoA.setObject_id("different id than likeA");

        assertThat(likeCountDtoA).isNotEqualTo(likeCountDtoB);
    }
}
