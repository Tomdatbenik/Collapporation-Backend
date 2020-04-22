package com.collapperation.userservice.service;

import com.collapperation.userservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/user.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    public void getUserTest() {
        final User user = userService.getUser("0");

        assertThat(user).isNotNull();
    }

    @Test
    public void getNullTest(){
        final User user = userService.getUser("not an id");

        assertThat(user).isNull();
    }
}
