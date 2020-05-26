package com.collapporation.likeservice.event;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LikeValidatedEventTest
{
    @Test
    public void allArgsConstructorTest()
    {
        final LikeValidatedEvent likeValidatedEvent = new LikeValidatedEvent("1", "2");

        assertThat(likeValidatedEvent).isNotNull();
        assertThat(likeValidatedEvent.getCreator()).isEqualTo("like-service");
    }

    @Test
    public void equalsTest()
    {
        final LikeValidatedEvent likeValidatedEventA = new LikeValidatedEvent();
        final LikeValidatedEvent likeValidatedEventB = new LikeValidatedEvent();

        assertThat(likeValidatedEventA).isEqualTo(likeValidatedEventB);
    }

    @Test
    public void notEqualTest()
    {
        final LikeValidatedEvent likeValidatedEventA = new LikeValidatedEvent("1", "2");
        final LikeValidatedEvent likeValidatedEventB = new LikeValidatedEvent();

        assertThat(likeValidatedEventA).isNotEqualTo(likeValidatedEventB);
    }
}
