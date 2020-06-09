package com.collapperation.userservice.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class UserTests {

    @Test
    public void noArgsConstructorTest() {
        final User user = new User();

        assertThat(user).isNotEqualTo(null);
        assertThat(user.getBio()).isNull();
        assertThat(user.getId()).isNull();
        assertThat(user.getFirstName()).isNull();
        assertThat(user.getLastName()).isNull();
        assertThat(user.getPicture()).isNull();
        assertThat(user.getUsername()).isNull();
    }

    @Test
    public void allArgsConstructorTest() {
        final String bio = "dfghjk ydevuvcyuyucg hyuwyucyecyug";
        final String id = "esrdftgyujhik";
        final String firstName = "ieeew2iu";
        final String lastName = "ddvyweydu2";
        final String picture = "https://picsum.photos/510/300?random";
        final String userName = "ebyufvcyuyui hchewbhhbuvhbu";
        final String functionTitle = "some job";
        final User user = new User(id, userName, firstName, lastName, bio, picture, functionTitle);

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(userName);
        assertThat(user.getPicture()).isEqualTo(picture);
        assertThat(user.getLastName()).isEqualTo(lastName);
        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getBio()).isEqualTo(bio);
        assertThat(user.getFunctionTitle()).isEqualTo(functionTitle);
    }

    @Test
    public void equalsTest() {
        final User userA = new User();
        final User userB = new User();

        assertThat(userA).isEqualTo(userB);
    }

    @Test
    public void notEqualTest(){
        final User userA = new User();
        final User userB = new User();

        userA.setPicture("to something");

        assertThat(userA).isNotEqualTo(userB);
    }
}
