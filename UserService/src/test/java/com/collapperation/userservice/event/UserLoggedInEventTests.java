package com.collapperation.userservice.event;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class UserLoggedInEventTests {

    @Test
    public void noArgsConstructorTest(){
        final UserLoggedInEvent userLoggedInEvent = new UserLoggedInEvent();

        assertThat(userLoggedInEvent).isNotNull();
        assertThat(userLoggedInEvent.getPicture()).isNull();
        assertThat(userLoggedInEvent.getUsername()).isNull();
        assertThat(userLoggedInEvent.getUuid()).isNull();
        assertThat(userLoggedInEvent.getCreator()).isEqualTo("user-service");
    }

    @Test
    public void allArgsConstructorTest(){
        final String picture = "a url";
        final String userName = "dwqftyegi";
        final String uuid = "ewfyweyf";
        final UserLoggedInEvent userLoggedInEvent =  new UserLoggedInEvent(uuid, userName, picture);

        assertThat(userLoggedInEvent).isNotNull();
        assertThat(userLoggedInEvent.getCreator()).isEqualTo("user-service");
        assertThat(userLoggedInEvent.getUuid()).isEqualTo(uuid);
        assertThat(userLoggedInEvent.getUsername()).isEqualTo(userName);
        assertThat(userLoggedInEvent.getPicture()).isEqualTo(picture);
    }

    @Test
    public void equalsTest(){
        final UserLoggedInEvent userLoggedInEventA = new UserLoggedInEvent();
        final UserLoggedInEvent userLoggedInEventB = new UserLoggedInEvent();

        assertThat(userLoggedInEventA).isEqualTo(userLoggedInEventB);
    }

    @Test
    public void notEqualTest(){
        final UserLoggedInEvent userLoggedInEventA = new UserLoggedInEvent();
        final UserLoggedInEvent userLoggedInEventB = new UserLoggedInEvent();

        userLoggedInEventA.setPicture("something");

        assertThat(userLoggedInEventA).isNotEqualTo(userLoggedInEventB);
    }
}
