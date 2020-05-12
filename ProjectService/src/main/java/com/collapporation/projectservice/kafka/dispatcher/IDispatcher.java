package com.collapporation.projectservice.kafka.dispatcher;

import com.collapporation.projectservice.event.Event;

public interface IDispatcher {
    void dispatch(String topic, Event event);
}
