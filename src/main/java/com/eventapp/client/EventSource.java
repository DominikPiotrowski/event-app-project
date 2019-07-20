package com.eventapp.client;

import com.eventapp.models.CommonEvent;

public interface EventSource {
    CommonEvent getEventData();
}