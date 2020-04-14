package com.collapporation.tokenservice.dispatcher;

import com.collapporation.tokenservice.events.Event;

public interface Dispatcher {
    void dispatch(String topic, Event event);
}
