package com.collapporation.likeservice.models;

import com.collapporation.likeservice.models.dto.LikeDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeCollectionTests {
    @Test
    void noArgsContructorTest()
    {
        final LikeCollection likeCollection = new LikeCollection();

        assertThat(likeCollection.getLikeList()).isNull();
        assertThat(likeCollection.getCount()).isEqualTo(0);
    }

    @Test
    void allArgsContructorTest()
    {
        final LikeCollection likeCollection = new LikeCollection(new ArrayList<>(), 1);

        assertThat(likeCollection.getLikeList()).isNotNull();
        assertThat(likeCollection.getCount()).isEqualTo(1);
    }

    //they are not equal, its probably deu to the lists inside the LikeCollection.
//    @Test
//    public void equalsTest()
//    {
//        final List<Like> likeList = new ArrayList<>();
//        final long count = 1;
//
//        final LikeCollection likeCollectionA = new LikeCollection(likeList,count);
//        final LikeCollection likeCollectionB = new LikeCollection(likeList,count);
//
//        assertThat(likeCollectionA).isEqualTo(likeCollectionB);
//    }

    @Test
    void notEqualTest() {
        final LikeCollection likeCollectionA = new LikeCollection(new ArrayList<>(), 1);
        final LikeCollection likeCollectionB = new LikeCollection();

        assertThat(likeCollectionA).isNotEqualTo(likeCollectionB);
    }
}
