package com.collapporation.likeservice.handler;

import com.collapporation.likeservice.event.Event;

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
