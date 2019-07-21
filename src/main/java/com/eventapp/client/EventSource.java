package com.eventapp.client;

import com.eventapp.models.CommonEvent;

import java.io.IOException;
import java.util.List;

public interface EventSource {
    List<CommonEvent> getEventData() throws IOException;
}