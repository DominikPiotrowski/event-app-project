package com.eventapp.client;

import com.eventapp.models.CommonEvent;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EventSource {
    List<CommonEvent> getEventData(Map parameters) throws IOException;
}