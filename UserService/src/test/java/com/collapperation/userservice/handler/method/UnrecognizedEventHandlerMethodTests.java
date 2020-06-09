package com.collapperation.userservice.handler.method;

import com.collapperation.userservice.event.UserLoggedInEvent;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ActiveProfiles("test")
public class UnrecognizedEventHandlerMethodTests
{
    @Test
    public void noArgsConstructorTest()
    {
        assertDoesNotThrow(() -> {
            new UnrecognizedEventHandlerMethod();
        });
    }

    @Test
    public void handleTest()
    {
        final UnrecognizedEventHandlerMethod handlerMethod = new UnrecognizedEventHandlerMethod();
        assertDoesNotThrow(() -> handlerMethod.handle(new UserLoggedInEvent()));
    }
}
