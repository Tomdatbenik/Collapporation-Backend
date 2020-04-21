package com.collapporation.projectservice.handler;

import com.collapporation.projectservice.event.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EventHandler {
    private final List<HandlerMethod> handlerMethods;
    private final UnrecognizedEventHandlerMethod unrecognizedEventHandlerMethod;

    public void processEvent(Event event){
        final HandlerMethod method = handlerMethods.stream()
                .filter(x -> x.getHandlingType() == event.getClass())
                .findFirst()
                .orElse(unrecognizedEventHandlerMethod);
        method.handle(event);
    }
}