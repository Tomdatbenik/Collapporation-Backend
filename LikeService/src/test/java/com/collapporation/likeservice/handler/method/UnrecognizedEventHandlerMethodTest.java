package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.LikeValidatedEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UnrecognizedEventHandlerMethodTest
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
        assertDoesNotThrow(() -> handlerMethod.handle(new LikeValidatedEvent()));
    }
}
