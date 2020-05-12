package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.UserLoggedInEvent;
import com.collapperation.userservice.model.User;
import com.collapperation.userservice.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Sql(scripts = {"/test/user.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserLoggedInEventHandlerMethodTests {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void allArgsConstructorTest(){
        assertDoesNotThrow(() -> {new UserLoggedInEventHandlerMethod(userRepo);});
    }

    @Test
    public void handlingTypeTest(){
        final UserLoggedInEventHandlerMethod userLoggedInEventHandlerMethod = new UserLoggedInEventHandlerMethod(userRepo);

        assertThat(userLoggedInEventHandlerMethod).isNotNull();
        assertThat(userLoggedInEventHandlerMethod.getHandlingType()).isEqualTo(UserLoggedInEvent.class);
    }

    @Test
    @Transactional
    public void updatesUserBasicInfoTest(){
        final String id = "0";
        final String username = "new userName";
        final String picture = "new picture";
        final UserLoggedInEventHandlerMethod userLoggedInEventHandlerMethod = new UserLoggedInEventHandlerMethod(userRepo);

        userLoggedInEventHandlerMethod.handle(new UserLoggedInEvent(id, username, picture));
        final User user = userRepo.getOne(id);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPicture()).isEqualTo(picture);
    }
}
