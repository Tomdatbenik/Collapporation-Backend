package com.collapperation.templateservice.handler.method;

import com.collapperation.templateservice.event.Event;
import com.collapperation.templateservice.handler.HandlerMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UnrecognizedEventHandlerMethod extends HandlerMethod<Event> {
    private final Logger logger = LoggerFactory.getLogger(UnrecognizedEventHandlerMethod.class);

    protected UnrecognizedEventHandlerMethod() {
        super(Event.class);
    }

    @Override
    public void handle(Event event) {
        logger.info("could not find: {}", event.getClass().getSimpleName());
    }
}
