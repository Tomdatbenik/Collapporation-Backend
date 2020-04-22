package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

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
        assertThat(userLoggedInEventHandlerMethod.getHandlingType()).isOfAnyClassIn(UserLoggedInEventHandlerMethod.class);
    }

    @Test
    public void updatesUserBasicInfoTest(){

    }
}
