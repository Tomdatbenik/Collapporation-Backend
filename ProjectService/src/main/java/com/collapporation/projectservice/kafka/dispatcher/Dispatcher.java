package com.collapporation.projectservice.kafka.dispatcher;

import com.collapporation.projectservice.event.Event;

public interface Dispatcher {
    void dispatch(String topic, Event event);
}
