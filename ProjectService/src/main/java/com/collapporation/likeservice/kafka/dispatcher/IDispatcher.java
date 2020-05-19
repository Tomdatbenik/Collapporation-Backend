package com.collapporation.likeservice.kafka.dispatcher;

import com.collapporation.likeservice.event.Event;

public interface IDispatcher {
    void dispatch(String topic, Event event);
}
