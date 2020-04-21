package com.collapperation.projectservice.handler;

import com.collapperation.projectservice.event.Event;

public abstract class HandlerMethod<T extends Event> {
    private final Class<T> clazz;

    protected HandlerMethod(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class getHandlingType() {
        return clazz;
    }

    public abstract void handle(T event);
}
