package com.collapporation.likeservice.event;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateLikeEventTest
{
    @Test
    void allArgsConstructorTest()
    {
        final ValidateLikeEvent validateLikeEvent = new ValidateLikeEvent("1", "2");

        assertThat(validateLikeEvent).isNotNull();
        assertThat(validateLikeEvent.getCreator()).isEqualTo("like-service");
    }

    @Test
    void equalsTest()
    {
        final ValidateLikeEvent likeValidatedEventA = new ValidateLikeEvent();
        final ValidateLikeEvent likeValidatedEventB = new ValidateLikeEvent();

        assertThat(likeValidatedEventA).isEqualTo(likeValidatedEventB);
    }

    @Test
    void notEqualTest()
    {
        final ValidateLikeEvent likeValidatedEventA = new ValidateLikeEvent("1", "2");
        final ValidateLikeEvent likeValidatedEventB = new ValidateLikeEvent();

        assertThat(likeValidatedEventA).isNotEqualTo(likeValidatedEventB);
    }
}
