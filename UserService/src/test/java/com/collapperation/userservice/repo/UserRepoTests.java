package com.collapperation.userservice.repo;

import com.collapperation.userservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/user.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRepoTests {
    @Autowired
    private UserRepo userRepo;

    @Test
    @Transactional
    public void updateBasicUserInfoTest(){
        final String id = "0";
        final String username = "new userName";
        final String picture = "new picture";

        userRepo.updateBasicUserInfo(picture, username, id);
        final User user = userRepo.getOne(id);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPicture()).isEqualTo(picture);
    }
}
