package com.collapperation.userservice.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(user.getUserName()).isNull();
    }

    @Test
    public void allArgsConstructorTest() {
        final String bio = "dfghjk ydevuvcyuyucg hyuwyucyecyug";
        final String id = "esrdftgyujhik";
        final String firstName = "ieeew2iu";
        final String lastName = "ddvyweydu2";
        final String picture = "https://picsum.photos/510/300?random";
        final String userName = "ebyufvcyuyui hchewbhhbuvhbu";
        final User user = new User(id, userName, firstName, lastName, bio, picture);

        assertThat(user).isNotNull();
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getPicture()).isEqualTo(picture);
        assertThat(user.getLastName()).isEqualTo(lastName);
        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getBio()).isEqualTo(bio);
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
