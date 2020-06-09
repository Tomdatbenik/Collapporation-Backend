package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.handler.method.UnrecognizedEventHandlerMethod;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

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
        assertDoesNotThrow(() -> handlerMethod.handle(new ProjectCreatedEvent()));
    }
}
