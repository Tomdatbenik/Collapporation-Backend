package com.collapperation.userservice.dispatcher;

import com.collapperation.userservice.event.Event;

public interface Dispatcher {
    void dispatch(String topic, Event event);
}
